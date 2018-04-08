package com.example.interaction_management_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@SpringBootApplication
public class InteractionManagementClientApplication {

	public static void main(String[] args) throws RestClientException, IOException {

		ApplicationContext ctx = SpringApplication.run(InteractionManagementClientApplication.class, args);
		InteractionManagementClient interactionManagementClient = ctx.getBean(InteractionManagementClient.class);
		System.out.println(interactionManagementClient);
		interactionManagementClient.getEmployee();
	}
	@Bean
	public InteractionManagementClient interactionManagementClient()
	{
		return new InteractionManagementClient();
	}
}
