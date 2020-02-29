package com.inventory.inventoryDetails.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inventory.inventoryDetails.model.Order;
import com.inventory.inventoryDetails.repositories.OrderRepositories;



@Component
public class OrderService {
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private OrderRepositories orderRepo;
	
	public Order createOrderservice(Order order) {
		try {
		order.setOrderDate(new Date());
		return orderRepo.save(order); 
		}
		
		catch(Exception e) {
			logger.error("Error Occured wile storing data in db");
			return null;
		}
		
	}
	
	
	
	
	public List<Order> getAllOrder() {
		try {
	
		return orderRepo.findAll(); 
		}
		
		catch(Exception e) {
			logger.error("Error Occured wile storing data in db");
			e.printStackTrace();
			return null;
		}
		
	}

}
