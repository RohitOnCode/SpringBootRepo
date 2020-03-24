package com.kafka.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.demo.service.KafkaService;
import com.kafka.dmo.dtos.ProductPartners;

@RestController
@RequestMapping("producer")
public class KafkaController {

	@Autowired
	private KafkaTemplate<String, ProductPartners> template;

	@Autowired
	private KafkaService kafkaservice;
	String topicName="SampleTopic";


	@PostMapping("postPartner")
	public void  sendData() {

		ProductPartners partner = kafkaservice.buildPartnerData();
		template.send(topicName,partner);



	}




}
