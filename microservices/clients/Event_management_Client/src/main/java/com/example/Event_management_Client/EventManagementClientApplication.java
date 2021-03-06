package com.example.Event_management_Client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@SpringBootApplication
public class EventManagementClientApplication {

	public static void main(String[] args) throws RestClientException, IOException {

		ApplicationContext ctx = SpringApplication.run(EventManagementClientApplication.class, args);
		Event_management_Client event_management_Client = ctx.getBean(Event_management_Client.class);
		System.out.println(event_management_Client);
		event_management_Client.getEmployee();
	}
	@Bean
	public Event_management_Client event_management_Client()
	{
		return new Event_management_Client();
	}
}
