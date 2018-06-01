package com.example.event_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.example.event_management"})
@EntityScan("com.example.event_management.Model")
@EnableJpaRepositories("com.example.event_management.Repository")
@SpringBootApplication
@EnableDiscoveryClient
public class EventManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventManagementApplication.class, args);
    }
}
