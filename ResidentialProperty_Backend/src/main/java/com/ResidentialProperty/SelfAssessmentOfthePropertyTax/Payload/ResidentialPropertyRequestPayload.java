package com.ResidentialProperty.SelfAssessmentOfthePropertyTax.Payload;


public class ResidentialPropertyRequestPayload {
 
    public int assessmentYear;

    public String ownerName;

    public String email;

    public String address;

    public String zonalClassification;

    public String description;

    public String status;

    public int constructedYear;

    public int builtUpArea;

	public int getAssessmentYear() {
		return assessmentYear;
	}

	public void setAssessmentYear(int assessmentYear) {
		this.assessmentYear = assessmentYear;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZonalClassification() {
		return zonalClassification;
	}

	public void setZonalClassification(String zonalClassification) {
		this.zonalClassification = zonalClassification;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getConstructedYear() {
		return constructedYear;
	}

	public void setConstructedYear(int constructedYear) {
		this.constructedYear = constructedYear;
	}

	public int getBuiltUpArea() {
		return builtUpArea;
	}

	public void setBuiltUpArea(int builtUpArea) {
		this.builtUpArea = builtUpArea;
	}

	@Override
	public String toString() {
		return "ResidentialPropertyRequestPayload [assessmentYear=" + assessmentYear + ", ownerName=" + ownerName
				+ ", email=" + email + ", address=" + address + ", zonalClassification=" + zonalClassification
				+ ", description=" + description + ", status=" + status + ", constructedYear=" + constructedYear
				+ ", builtUpArea=" + builtUpArea + "]";
	}    

}
