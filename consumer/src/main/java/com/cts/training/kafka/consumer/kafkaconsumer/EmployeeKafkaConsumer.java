package com.cts.training.kafka.consumer.kafkaconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.cts.training.kafka.consumer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeKafkaConsumer {

	private ObjectMapper mapper = new ObjectMapper();
	
	private final Logger log = LoggerFactory.getLogger(EmployeeKafkaConsumer.class);
	
	@KafkaListener(topics = "employeetopic")
	public void consume(String message) throws Exception, JsonProcessingException {
		Employee employee = this.mapper.readValue(message, Employee.class);
		log.info("Employee is {}", employee);
	}
}
