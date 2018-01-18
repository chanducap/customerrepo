
package com.practise.customer.vo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Component
@Entity
@Table(name="customer")
@JsonInclude(value = Include.NON_NULL)
public class CustomerVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer customerId;
	@Column(name = "phone_number", length = 20)
	@NotNull
	private String phoneNumber;
	@Column(name = "first_number", length = 255)
	@NotNull
	private String firstName;
	@Column(name = "last_number", length = 255)
	@NotNull
	private String lastName;
	@Column(name = "ssn", length = 15)
	private String ssn;
	@Column(name = "dob", length = 15)
	private String dob;
	@Column(name="status",length = 15)
	@JsonIgnore
	private  Integer status;

	public CustomerVO()
	{

	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return String.format("Customer[customerId=%d, phoneNumber=%s, firstName='%s', lastName='%s',ssn='%s',dob='%s',status='%d']",
				customerId, phoneNumber, firstName, lastName, ssn, dob,status);

	}



}


