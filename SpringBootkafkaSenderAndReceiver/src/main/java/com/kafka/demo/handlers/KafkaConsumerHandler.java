package com.kafka.demo.handlers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.dmo.dtos.ProductPartners;
@Service
public class KafkaConsumerHandler {


	
	/**
	 * 
	 * 
	 * Here we are using kafkaListener consumerFactory which we created in KafkaConsumerConfig.
	 * This is to be created when we do not rely on kafka-spring auto configuration.
	 * The kafka auto configuration can be turned off in application.properties file.
	 * @param partner
	 */
    @KafkaListener(topics = "SampleTopic", groupId = "sample-group",containerFactory = "kafkaListener")
    public void consume(ProductPartners partner){
        System.out.println("Consumed Message :"+partner);
    }
}