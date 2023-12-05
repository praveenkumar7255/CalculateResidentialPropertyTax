package com.ResidentialProperty.SelfAssessmentOfthePropertyTax.Repository;

import com.ResidentialProperty.SelfAssessmentOfthePropertyTax.Entity.TaxValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxValueRepository extends JpaRepository<TaxValue,Integer> {

    @Query("SELECT c.taxValue from TaxValue c WHERE c.description = :description AND c.status = :status AND c.zonalClassification = :zonalClassification")
    double findTaxValueByFields(@Param("description") String description,@Param("status") String status,@Param("zonalClassification") String zonalClassification);

}