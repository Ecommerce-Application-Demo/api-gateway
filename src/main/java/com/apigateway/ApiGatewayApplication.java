package com.apigateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Scheduled(fixedRate = 5,timeUnit = TimeUnit.MINUTES)
	public void scheduled() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForEntity("https://ecommerce-backend-dev.onrender.com/actuator/info", String.class);
	}
}
