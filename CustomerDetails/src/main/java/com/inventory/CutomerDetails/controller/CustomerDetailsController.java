package com.inventory.CutomerDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.CutomerDetails.model.Customer;
import com.inventory.CutomerDetails.service.CustomerService;

@RestController
@RequestMapping(value= "/api/mongo/customer")
public class CustomerDetailsController {


	@Autowired
	private CustomerService customerser;

	@PostMapping("/create")
	public Customer createOrder(@RequestBody Customer customer ) {
		return  customerser.createOrderservice(customer);

	}

	@GetMapping("/getAllCustomers")
	public List<Customer> getAllOrders() {
		return  customerser.getAllOrder();

	}
}



