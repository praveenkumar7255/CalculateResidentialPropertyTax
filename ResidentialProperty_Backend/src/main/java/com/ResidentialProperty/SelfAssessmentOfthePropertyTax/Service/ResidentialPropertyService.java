package com.ResidentialProperty.SelfAssessmentOfthePropertyTax.Service;

import com.ResidentialProperty.SelfAssessmentOfthePropertyTax.Entity.ResidentialProperty;
import com.ResidentialProperty.SelfAssessmentOfthePropertyTax.Payload.ResidentialPropertyRequestPayload;
import com.ResidentialProperty.SelfAssessmentOfthePropertyTax.Repository.ResidentialPropertyRepository;
import com.ResidentialProperty.SelfAssessmentOfthePropertyTax.Repository.TaxValueRepository;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResidentialPropertyService {

    @Autowired
    private ResidentialPropertyRepository residentialPropertyRepository;

    @Autowired
    private TaxValueRepository taxValueRepository;

    @Transactional
    public double propertyTaxSubmit(ResidentialPropertyRequestPayload requestPayload) throws Exception {

    	double taxValue  = getTaxValue(requestPayload);
        int total1 = (int) (requestPayload.getBuiltUpArea()*taxValue*10);

        double depreciationValue = (requestPayload.getAssessmentYear()-requestPayload.getConstructedYear()) <60 ?
        		                             (double)(requestPayload.getAssessmentYear()-requestPayload.getConstructedYear())/100.0 : (0.6 / 100.0);
        double total2 = total1 - (depreciationValue * total1);
        double total3 = total2 * 0.20;
        double total4 = total3 * 0.24;
        double totalPropertyTax = total3 + total4;
        String formattedValue = String.format("%.2f", totalPropertyTax);
        double finalPropertyTax = Double.parseDouble(formattedValue);

        ResidentialProperty residentialProperty = new ResidentialProperty();
        residentialProperty.setAssessmentYear(requestPayload.getAssessmentYear());
        residentialProperty.setOwnerName(requestPayload.getOwnerName());
        residentialProperty.setEmail(requestPayload.getEmail());
        residentialProperty.setAddress(requestPayload.getAddress());
        residentialProperty.setZonalClassification(requestPayload.getZonalClassification());
        residentialProperty.setDescription(requestPayload.getDescription());
        residentialProperty.setStatus(requestPayload.getStatus());
        residentialProperty.setConstructedYear(requestPayload.getConstructedYear());
        residentialProperty.setBuiltUpArea(requestPayload.getBuiltUpArea());
        residentialProperty.setTotalPropertyTax(finalPropertyTax);
        residentialPropertyRepository.save(residentialProperty);
        return finalPropertyTax;
    }
    
    private double getTaxValue(ResidentialPropertyRequestPayload requestPayload) throws Exception {
        if((requestPayload.getDescription() ==null || requestPayload.getDescription().isEmpty()) || (requestPayload.getStatus() ==null || requestPayload.getStatus().isEmpty()) 
        		        || (requestPayload.getZonalClassification() ==null || requestPayload.getZonalClassification().isEmpty())){
        	throw new Exception("Record with discription or status or zonalClassification not exist in Database");
        }else{
            return taxValueRepository.findTaxValueByFields(requestPayload.getDescription(),requestPayload.getStatus(),requestPayload.getZonalClassification());
        }
    }

    @Transactional
	public double getTotalAmountByZone(String zonalClassification, String status,Integer assessmentYear) {

		List<ResidentialProperty> records = residentialPropertyRepository.findByZonalClassificationAndStatusAndAssessmentYear(zonalClassification, status, assessmentYear);
		double totalAmount = records.stream().mapToDouble(ResidentialProperty::getTotalPropertyTax).sum();
		 String formattedValue = String.format("%.2f", totalAmount);
	     double finalTotalAmount = Double.parseDouble(formattedValue);
		return finalTotalAmount;
	}

}
