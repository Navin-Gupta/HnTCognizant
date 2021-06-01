package com.cts.training.kafka.producer.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cts.training.kafka.producer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeKafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public void send(Employee employee) throws Exception {
		String json = this.mapper.writeValueAsString(employee);
		this.kafkaTemplate.send("employeetopic", json);
	}
	
}
