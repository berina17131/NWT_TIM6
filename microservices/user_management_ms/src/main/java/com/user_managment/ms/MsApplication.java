package com.user_managment.ms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages= "com")
@ComponentScan({"com.user_managment.ms"})
@EnableAutoConfiguration
public class MsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			repository.save(new User("Emir", "Baručija"));
			repository.save(new User("Selmir", "Hasanović"));
			repository.save(new User("Berina", "Muhović"));
			repository.save(new User("Amra", "Mujčinović"));
			repository.save(new User("Irfan", "Prazina"));
			repository.save(new User("Neko1", "Prazina"));
			repository.save(new User("Neko2", "Prazina"));

			System.out.println("User found with findByPrezime('Prazina'):");
			System.out.println("--------------------------------------------");
			repository.findByPrezime("Prazina").forEach(bauer -> {
				System.out.println(bauer.toString());
			});
		};
	}
}
