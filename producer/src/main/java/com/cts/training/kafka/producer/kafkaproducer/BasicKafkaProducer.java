package com.cts.training.kafka.producer.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

// @Service
public class BasicKafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) {
		this.kafkaTemplate.send("secondtopic", message);
	}
}
