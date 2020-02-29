package com.inventory.inventoryDetails.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventory.inventoryDetails.model.Order;
import com.inventory.inventoryDetails.service.OrderService;

@RestController
@RequestMapping(value = "/api/mongo/order")
public class OrderDetailsController {

	private RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private OrderService orderser;

	@PostMapping("/create")
	public Order createOrder(@RequestBody Order order) {
		return orderser.createOrderservice(order);

	}

	@GetMapping("/getAllOrders")
	public List<Order> getAllOrders() {
		return orderser.getAllOrder();

	}

	@GetMapping("/getAllCustomers")
	public Map<String,Object> getAllCustomer() {
		String uri = "http://localhost:8033/api/mongo/customer/getAllCustomers";
		return convertToMap(restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<Object>() {
		}).getBody());

	}

	public Map<String, Object> convertToMap(Object obj) {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		System.out.println(obj.toString());
		
			return mapper.convertValue(obj,new TypeReference<List<Map<String, Object>>>() {}).get(0);
		
		
	}}

		