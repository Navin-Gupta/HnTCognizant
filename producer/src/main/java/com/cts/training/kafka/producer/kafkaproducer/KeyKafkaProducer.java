package com.cts.training.kafka.producer.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

// @Service
public class KeyKafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void send(String key, String message) {
		this.kafkaTemplate.send("partitiontopicpro", key, message);
	}
}
