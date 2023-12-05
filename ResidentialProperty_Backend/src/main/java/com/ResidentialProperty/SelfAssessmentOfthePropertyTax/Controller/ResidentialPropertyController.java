package com.ResidentialProperty.SelfAssessmentOfthePropertyTax.Controller;

import com.ResidentialProperty.SelfAssessmentOfthePropertyTax.Payload.ResidentialPropertyRequestPayload;
import com.ResidentialProperty.SelfAssessmentOfthePropertyTax.Service.ResidentialPropertyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/propertyTax")
public class ResidentialPropertyController {

    @Autowired
    private ResidentialPropertyService residentialPropertyService;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @PostMapping(value="/submit")
    public double propertyTaxSubmission(@RequestBody String requestBody) {
        try {
            ResidentialPropertyRequestPayload residentialPropertyRequestPayload =
                    objectMapper.readValue(requestBody, ResidentialPropertyRequestPayload.class);

             double propertyTax = residentialPropertyService.propertyTaxSubmit(residentialPropertyRequestPayload);

            return propertyTax;
        } catch (Exception e) {
            return 0.00;
        }
    }
    
    @GetMapping("/total_amount")
    public double getTotalAmountCollected(@RequestParam String zonalClassification,
    		                                  @RequestParam String status,@RequestParam Integer assessmentYear) {
    	
    	return residentialPropertyService.getTotalAmountByZone(zonalClassification,status,assessmentYear);
    }
    
    
    @GetMapping("/home")
    public ModelAndView homePage() {
        return new ModelAndView("homePage");
    }
    
    @GetMapping("/selfAssessmentForm")
    public ModelAndView selfAssessmentForm(Model model) {
    	ResidentialPropertyRequestPayload residentialPropertyRequestPayload = new ResidentialPropertyRequestPayload();
        
        model.addAttribute("residentialPropertyRequestPayload",residentialPropertyRequestPayload);

        return new ModelAndView("propertyDetailsView","model",model);
}
    
    @GetMapping("/zonalReport")
    public ModelAndView zonalReportView() {
        return new ModelAndView("zoneReportView");
    }
}
