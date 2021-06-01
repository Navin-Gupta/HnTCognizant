package com.cts.training.kafka.producer;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.cts.training.kafka.producer.entity.Employee;
import com.cts.training.kafka.producer.kafkaproducer.BasicKafkaProducer;
import com.cts.training.kafka.producer.kafkaproducer.EmployeeKafkaProducer;
import com.cts.training.kafka.producer.kafkaproducer.KeyKafkaProducer;

@SpringBootApplication
// @EnableScheduling
public class ProducerApplication implements CommandLineRunner {

	//@Autowired
	//private BasicKafkaProducer producer;
	
	//@Autowired
	//private KeyKafkaProducer producer;
	
	@Autowired
	private EmployeeKafkaProducer producer;
	
	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// this.producer.sendMessage("Hello All"); 
		/*for(int i=0; i<1000;i++) {
			String key = "key-" + (i % 4);
			String message = "Data " + i + " with key " + key;
			this.producer.send(key, message);
			
			Thread.sleep(500);
		}*/
		
		for(int i = 0; i<5; i++) {
			Employee employee = new Employee("Emp-" + i, "Employee-" + i,"employee" + i + "@mail.com");
			this.producer.send(employee);
		}
	}

}
