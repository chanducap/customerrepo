package com.tmobile.poc.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Component
@JsonInclude(value = Include.NON_NULL)
public class CustomerInfoVO extends CustomerAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String dob;
	private String ssn;
	
	/**
	 * @param customerId
	 * @param phoneNumber
	 * @param firstName
	 * @param lastName
	 * @param dob
	 * @param ssn
	 */
	public CustomerInfoVO(Integer customerId, String phoneNumber, String firstName, String lastName, String dob,
			String ssn) {
		super(customerId, phoneNumber);
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.ssn = ssn;
	}

	public CustomerInfoVO() {
		// Blank Constructor
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSsn() {
		String str = "";
		if (this.ssn != null && this.ssn.length() == 12) {
			str = "xxx-xxx-";
			str = str + this.ssn.substring(8, this.ssn.length());
		}
		return str;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "CustomerInfoVO [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", ssn=" + ssn
				+ "]";
	}
	
}
