package com.hcl.ClaimsManagementSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;



@Entity
public class Claim {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long claimsId;
	
	@NotNull
	private Status status;
	
	@NotNull
	private TypeOfClaim typeOfClaim;
	
	@NotBlank
	@Size(min = 3,message = "Business Justification should have a minimum of 3 characters")
	@Size(max = 200,message = "Business Justification should not have more than 200 characters")
	private String businessJustification;
	

	public Claim(Status status, TypeOfClaim typeOfClaim, String businessJustification) {
		super();
		this.status = status;
		this.typeOfClaim = typeOfClaim;
		this.businessJustification = businessJustification;
	
	}

	public Claim() {
		super();
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TypeOfClaim getTypeOfClaim() {
		return typeOfClaim;
	}

	public void setTypeOfClaim(TypeOfClaim typeOfClaim) {
		this.typeOfClaim = typeOfClaim;
	}

	public String getBusinessJustification() {
		return businessJustification;
	}

	public void setBusinessJustification(String businessJustification) {
		this.businessJustification = businessJustification;
	}

	public long getClaimsId() {
		return claimsId;
	}

	@Override
	public String toString() {
		return "Claim [claimsId=" + claimsId + ", status=" + status + ", typeOfClaim=" + typeOfClaim
				+ ", businessJustification=" + businessJustification + "]";
	}
	public enum Status{
		ACCEPTED,
		REJECTED,
		AWAITING_APPROVAL
	}

	public enum TypeOfClaim{
		MEDICAL,
		TRAVEL,
		BROADBAND
	}
	
}


