package com.example.usermanagementclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@SpringBootApplication
public class UserManagementClientApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx = SpringApplication.run(
				UserManagementClientApplication.class, args);

		UserManagementClient userManagementClient = ctx.getBean(UserManagementClient.class);
		userManagementClient.getAllUsers();
	}

	@Bean
	public UserManagementClient userManagementClient()
	{
		return new UserManagementClient();
	}

}
