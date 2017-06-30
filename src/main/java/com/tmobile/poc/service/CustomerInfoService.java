package com.tmobile.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmobile.poc.repository.CustomerDAORepository;
import com.tmobile.poc.vo.CustomerVO;

@Service
public class CustomerInfoService {
	@Autowired
	private CustomerDAORepository repository;
	

	public CustomerVO getCustomerInfoByPhoneNumber(String phoneNumber) {
	
		return repository.findCustomerByPhoneNumber(phoneNumber);
	}

	public CustomerVO saveCustomerInfo(CustomerVO customer) {
		if (customer != null) {
			customer.setCustomerId(customer.getCustomerId());

		}
		return repository.save(customer);

	}

	public CustomerVO updateCustomerInfo(CustomerVO customer) {

		return repository.save(customer);
	}
}
