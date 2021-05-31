package com.cts.training.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.training.kafka.producer.kafkaproducer.BasicKafkaProducer;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

	@Autowired
	private BasicKafkaProducer producer;
	
	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		this.producer.sendMessage("Hello All");
		
	}

}
