package com.example.place_management_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@SpringBootApplication
public class PlaceManagementClientApplication {


	public static void main(String[] args) throws RestClientException, IOException {

		ApplicationContext ctx = SpringApplication.run(PlaceManagementClientApplication.class, args);

		PlaceManagementClient placeManagementClient=ctx.getBean(PlaceManagementClient.class);
		System.out.println(placeManagementClient);
		placeManagementClient.getEmployee();
	}
	@Bean
	public PlaceManagementClient placeManagementClient()
	{
		return new PlaceManagementClient();
	}
}
