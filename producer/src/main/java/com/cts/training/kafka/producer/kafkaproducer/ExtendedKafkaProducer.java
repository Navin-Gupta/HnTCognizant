package com.cts.training.kafka.producer.kafkaproducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

// @Service
public class ExtendedKafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private int i = 0;
	
	private Logger log = LoggerFactory.getLogger(ExtendedKafkaProducer.class);
	
	@Scheduled(fixedRate = 1000)
	public void sendMessage() {
		i++;
		log.info("i is " + i);
		this.kafkaTemplate.send("test1topic", "Extended " + i);
	}
}
