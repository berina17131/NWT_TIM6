package com.example.interaction_management;

import com.example.interaction_management.Model.*;
import com.example.interaction_management.Repository.EventRepository;
import com.example.interaction_management.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@ComponentScan({"com.example.interaction_management"})
@EntityScan("com.example.interaction_management.Model")
@EnableJpaRepositories("com.example.interaction_management.Repository")
@EnableDiscoveryClient
public class InteractionManagementApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(InteractionManagementApplication.class);


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EventRepository eventRepository;

	public static void main(String[] args) {
		SpringApplication.run(InteractionManagementApplication.class, args);
	}

	@Override
	@Transactional
	public void run (String... strings) throws  Exception {
		/*final User user1 = new User(1,"username1");
		userRepository.saveUser(user1.getId(), user1.getUsername());
		log.info(user1.toString());

		final Event event1 = new Event(1, "Eveent");

		final Grade grade1 = new Grade(5);
		final Grade grade2 = new Grade(3);

		final Comment comment1 = new Comment("Commmment");
		final Comment comment2 = new Comment("Cmnnft");

		final Status status1 = new Status("Going");
		final Status status2 = new Status("Interested");

		Set grades = new HashSet<Grade>(){{
		    add(grade1);
		    add(grade2);
        }};

        Set comments = new HashSet<Comment>(){{
            add(comment1);
            add(comment2);
        }};

        Set statuses = new HashSet<Status>(){{
            add(status1);
            add(status2);
        }};

        user1.setComments(comments);
        user1.setGrades(grades);
        user1.setStatuses(statuses);

        event1.setComments(comments);
        event1.setGrades(grades);
        event1.setStatuses(statuses);

        for (Event event : eventRepository.findAll()){
            log.info(event.toString());
        }

		for (User user : userRepository.findAll()){
			log.info(user.toString());
		}*/

	}

}
