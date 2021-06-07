package com.cts.training.aws.lambdaapp.endpoints;

import java.util.function.Function;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

@Component
public class UpperPro implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>{

	@Override
	public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent request) {
		// TODO Auto-generated method stub
		APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
		response.setStatusCode(HttpStatus.OK.value());
		response.setBody(request.getBody().toUpperCase());
		
		return response;
	}

}
