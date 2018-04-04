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
		Interaction_management_Client event_management_Client = ctx.getBean(Interaction_management_Client.class);
		System.out.println(event_management_Client);
		event_management_Client.getEmployee();
	}
	@Bean
	public Interaction_management_Client interaction_management_client()
	{
		return new Interaction_management_Client();
	}
}
