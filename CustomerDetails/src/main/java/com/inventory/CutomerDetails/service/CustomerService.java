package com.inventory.CutomerDetails.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inventory.CutomerDetails.model.Customer;
import com.inventory.CutomerDetails.repositories.CustomerRepositories;



@Component
public class CustomerService {
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CustomerRepositories customerRepo;
	
	public Customer createOrderservice(Customer customer) {
		try {
	
		return customerRepo.save(customer); 
		}
		
		catch(Exception e) {
			logger.error("Error Occured wile storing data in db");
			return null;
		}
		
	}
	
	
	
	
	public List<Customer> getAllOrder() {
		try {
	
		return customerRepo.findAll(); 
		}
		
		catch(Exception e) {
			logger.error("Error Occured wile storing data in db");
			e.printStackTrace();
			return null;
		}
		
	}

}
