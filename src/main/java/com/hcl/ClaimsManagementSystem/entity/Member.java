package com.hcl.ClaimsManagementSystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;



@Entity
public class Member {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long memberId;
	
	@NotBlank
	@Size(min = 3,message = "FirstName should have a minimum of 3 characters")
	@Size(max = 15,message = "FirstName should not have more than 15 characters")
	private String firstName;
	
	@NotBlank
	@Size(min = 3,message = "LastName should have a minimum of 3 characters")
	@Size(max = 15,message = "LastName should not have more than 15 characters")
	private String lastName;
	
	@NotNull
	@Range(min = 1,max=100,message = "Age should be a between 1 and 100")
	private int age;
	
	@NotNull
	private int contactNumber;
	
	@NotNull
	private Role role;
	
	@NotBlank
	private String email;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Claim> claims;
	


	public Member() {
		super();
	}
	
	
	public Member(String firstName, String lastName, int age, int contactNumber, String password, Role role, String email,
		List<Claim> claims) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.contactNumber = contactNumber;
	this.role = role;
	this.email = email;
	this.claims = claims;
}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Claim> getClaims() {
		return claims;
	}


	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}


	public long getMemberId() {
		return memberId;
	}


	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", contactNumber=" + contactNumber + ", role=" + role + ", email=" + email
				+ ", claims=" + claims + "]";
	}	
	
	public enum Role{
		ADMIN,
		MEMBER
	}

}

