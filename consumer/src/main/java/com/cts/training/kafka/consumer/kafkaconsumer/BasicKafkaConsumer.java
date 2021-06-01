package com.cts.training.kafka.consumer.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


// @Service
public class BasicKafkaConsumer {

	@KafkaListener(topics = "secondtopic")
	public void consume(String message) {
		// logic to process the data
		System.out.println(message);
		
	}
}
