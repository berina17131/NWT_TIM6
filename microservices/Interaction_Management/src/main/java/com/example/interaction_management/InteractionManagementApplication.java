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

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
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
		User user1 = new User("Us");
		Event event1 = new Event("Ev");

		Grade grade1 = new Grade(5);
		Grade grade2 = new Grade(3);

		Comment comment1 = new Comment("Co");
		Comment comment2 = new Comment("Cmnt");

		Status status1 = new Status("Going");
		Status status2 = new Status("Interested");

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

	}

}
