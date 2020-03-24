package com.kafka.demo.service;

import org.springframework.stereotype.Service;

import com.kafka.dmo.dtos.ProductPartners;

@Service
public class KafkaService {



	/**
	 * 
	 * Method to post to kafka queue
	 * @return
	 */
	public ProductPartners buildPartnerData() {
		ProductPartners partner= new ProductPartners();
		partner.setPartnerId("123");
		partner.setProductName("test");
		return partner;
	}

}
