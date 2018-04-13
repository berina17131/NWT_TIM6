package com.user_managment.ms.rabbitmq;

import com.user_managment.ms.Repository.UserRepository;
import com.user_managment.ms.Services.UserService;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventProducerConfiguration {

    @Bean
    public Exchange eventExchange() {
        return new TopicExchange("eventExchange");
    }

    @Bean
    public UserService userService(RabbitTemplate rabbitTemplate, Exchange eventExchange, UserRepository userRepository) {
        return new UserService(rabbitTemplate, eventExchange, userRepository);
    }
}
