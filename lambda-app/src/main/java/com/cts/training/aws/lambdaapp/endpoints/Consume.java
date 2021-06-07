package com.cts.training.aws.lambdaapp.endpoints;

import java.util.function.Consumer;

import org.springframework.stereotype.Component;

import com.cts.training.aws.lambdaapp.model.Product;

// @Component
public class Consume implements Consumer<Product>{

	@Override
	public void accept(Product product) {
		// TODO Auto-generated method stub
		System.out.println(product);
	}

}
