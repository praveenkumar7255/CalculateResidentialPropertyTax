package com.ResidentialProperty.SelfAssessmentOfthePropertyTax.Repository;

import com.ResidentialProperty.SelfAssessmentOfthePropertyTax.Entity.ResidentialProperty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentialPropertyRepository extends JpaRepository<ResidentialProperty,Integer> {

	@Query("SELECT rp FROM ResidentialProperty rp WHERE rp.zonalClassification = :zonalClassification AND rp.status = :status AND rp.assessmentYear = :assessmentYear")
	List<ResidentialProperty> findByZonalClassificationAndStatusAndAssessmentYear(@Param("zonalClassification") String zonalClassification, @Param("status") String status, @Param("assessmentYear") Integer assessmentYear);
	
}
