package com.ResidentialProperty.SelfAssessmentOfthePropertyTax.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ResidentialProperty.SelfAssessmentOfthePropertyTax.Entity.TaxValue;
import com.ResidentialProperty.SelfAssessmentOfthePropertyTax.Repository.TaxValueRepository;

@Component
public class DataInitializer implements CommandLineRunner{
	
	@Autowired
	private TaxValueRepository taxValueRepository;

	@Override
	public void run(String... args) throws Exception {
		
		if(taxValueRepository.count() == 0) {
			List<TaxValue> taxValueList = new ArrayList<>();
			
			taxValueList.add(new TaxValue("RCC buildings","Tenanted",5.00,"Zone A"));
			taxValueList.add(new TaxValue("RCC buildings","Tenanted",4.00,"Zone B"));
			taxValueList.add(new TaxValue("RCC buildings","Tenanted",3.60,"Zone C"));
			taxValueList.add(new TaxValue("RCC buildings","Owner",2.50,"Zone A"));
			taxValueList.add(new TaxValue("RCC buildings","Owner",2.00,"Zone B"));
			taxValueList.add(new TaxValue("RCC buildings","Owner",1.80,"Zone C"));
			taxValueList.add(new TaxValue("RCC buildings with cement or red-oxide flooring","Tenanted",4.00,"Zone A"));
			taxValueList.add(new TaxValue("RCC buildings with cement or red-oxide flooring","Tenanted",3.50,"Zone B"));
			taxValueList.add(new TaxValue("RCC buildings with cement or red-oxide flooring","Tenanted",3.00,"Zone C"));
			taxValueList.add(new TaxValue("RCC buildings with cement or red-oxide flooring","Owner",1.80,"Zone A"));
			taxValueList.add(new TaxValue("RCC buildings with cement or red-oxide flooring","Owner",1.60,"Zone B"));
			taxValueList.add(new TaxValue("RCC buildings with cement or red-oxide flooring","Owner",1.20,"Zone C"));
			taxValueList.add(new TaxValue("Tiled/Sheet of all kinds","Tenanted",3.00,"Zone A"));
			taxValueList.add(new TaxValue("Tiled/Sheet of all kinds","Tenanted",2.50,"Zone B"));
			taxValueList.add(new TaxValue("Tiled/Sheet of all kinds","Tenanted",2.00,"Zone C"));
			taxValueList.add(new TaxValue("Tiled/Sheet of all kinds","Owner",1.25,"Zone A"));
			taxValueList.add(new TaxValue("Tiled/Sheet of all kinds","Owner",1.00,"Zone B"));
			taxValueList.add(new TaxValue("Tiled/Sheet of all kinds","Owner",0.75,"Zone C"));
			
			taxValueRepository.saveAll(taxValueList);
		}
	}

}
