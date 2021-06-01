package com.cts.training.kafka.consumer.kafkaconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

// @Service
public class ExtendedKafkaConsumerPro {
	private final Logger log = LoggerFactory.getLogger(ExtendedKafkaConsumerPro.class);
	
	@KafkaListener(topics = "test2topic")
	public void consume(String message) {
		log.info("Consuming : " + message);
	}
}
