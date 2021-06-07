package com.cts.training.aws.lambdaapp.endpoints;

import java.util.function.Function;

import org.springframework.stereotype.Component;



// REst Endpoint to accept a string and return an upper case of it
// class name is rest endpoint
// @Component
public class Upper implements Function<String, String>{

	@Override
	public String apply(String str) {
		return str.toUpperCase();
	}

}
