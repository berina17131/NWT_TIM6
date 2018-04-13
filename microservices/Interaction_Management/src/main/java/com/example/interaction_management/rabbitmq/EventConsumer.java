package com.example.interaction_management.rabbitmq;


import com.example.interaction_management.Repository.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class EventConsumer {


    UserRepository userRepository;

    @Autowired
    public EventConsumer(UserRepository us)
    {
        this.userRepository = us;
    }

    @RabbitListener(queues="interactionServiceQueue")
    public void receive(String message) {
        userRepository.deleteById(Integer.parseInt(message));

            }

}