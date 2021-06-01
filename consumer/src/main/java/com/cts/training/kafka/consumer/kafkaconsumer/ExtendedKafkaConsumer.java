package com.cts.training.kafka.consumer.kafkaconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

// @Service
public class ExtendedKafkaConsumer {

	private final Logger log = LoggerFactory.getLogger(ExtendedKafkaConsumer.class);
	
	@KafkaListener(topics = "test1topic")
	public void consume(String message) {
		log.info("Consuming : " + message);
	}
}
