package com.example.interaction_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.example.interaction_management"})
@EntityScan("com.example.interaction_management.Model")
@EnableJpaRepositories("com.example.interaction_management.Repository")
@EnableDiscoveryClient
public class InteractionManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(InteractionManagementApplication.class, args);
    }
}
