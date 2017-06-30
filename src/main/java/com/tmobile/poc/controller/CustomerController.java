package com.tmobile.poc.controller;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmobile.poc.service.CustomerInfoService;
import com.tmobile.poc.vo.CustomerInfoVO;
import com.tmobile.poc.vo.CustomerVO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CustomerController {

	@Autowired
	private CustomerInfoService service;
	@Autowired
	private CustomerVO customer;

	@ApiOperation(value = "This method is used for getting the Customer Information by Phone Number!.")
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Customer Information is fetched as Sucess!"),
			@ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Customer Information ") })
	@GetMapping(value = "/api-service/v1/customers/customer/{phoneNumber}", produces = "application/json")
	public ResponseEntity<?> getCustomerInfo(@PathVariable(required=true,value="phoneNumber")String phoneNumber) {
		
			CustomerVO cust=service.getCustomerInfoByPhoneNumber(phoneNumber);
			return new ResponseEntity(cust, HttpStatus.OK);
		
		

	}

	@ApiOperation(value = "This method is used for Saving the Customer Information!. ")
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Customer Information is saved Sucessfully!"),
			@ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Error Occurred while processing the request! ") })
	@PostMapping(value = "/api-service/v1/customers/customer/save", produces = "application/json")
	public ResponseEntity<?> saveCustomerInfo(@RequestBody(required=true) CustomerVO customer) {
		if (customer != null && customer.getPhoneNumber() != null)
			try {
				customer =service.saveCustomerInfo(customer);
				return new ResponseEntity(customer, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity("Error Occurred while processing!", HttpStatus.BAD_REQUEST);
			}
		return null;
	}

	@ApiOperation(value = "This method is used for Updating the Customer Information!. ")
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Customer Information is saved Sucessfully!"),
			@ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Error Occurred while processing the request! ") })
	@PutMapping(value = "/v1/customers/customer/update", produces = "application/json")
	public ResponseEntity<?> updateCustomerInfo(@RequestBody(required=true) CustomerVO customer) {
		if (customer != null && customer.getPhoneNumber() != null)
			try {
				customer = service.updateCustomerInfo(customer);
				return new ResponseEntity(customer, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity("Error Occurred while processing!", HttpStatus.BAD_REQUEST);
			}
		return null;
	}

}
