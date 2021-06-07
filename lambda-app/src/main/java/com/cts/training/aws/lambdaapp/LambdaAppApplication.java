package com.cts.training.aws.lambdaapp;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cts.training.aws.lambdaapp.model.Product;

@SpringBootApplication
public class LambdaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LambdaAppApplication.class, args);
	}
	
	
	// Map all requirements to map functional interface
	// Consumer,Predicate, Function, Supplier
	// REST Endpoint to add a new product (Consumer)
	// method that would return a Consumer
	
	
	// method name is rest endpoint
	/*@Bean 
	public Consumer<Product> consumeProduct() {
		// return a consumer lambda function
		return product->System.out.println(product);
	}
	
	// REST endpoint to get list of all product
	@Bean
	public Supplier<List<Product>> getProducts(){
		return ()->{
			List<Product> products =new ArrayList<Product>();
			products.add(new Product(1, "Spring", "Backend", 500));
			products.add(new Product(1, "Angular", "Frontend", 600));
			products.add(new Product(1, "AWS", "cloud", 700));
			return products;
		};
	}*/
	

}
