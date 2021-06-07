package com.cts.training.aws.lambdaapp.handler;

// import org.springframework.cloud.function.adapter.aws.SpringBootApiGatewayRequestHandler;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

@Component
public class AWSLambdaHandler extends SpringBootRequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>{

}
