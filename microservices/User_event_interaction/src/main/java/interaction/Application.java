package interaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String args[]) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		GradeRepository gRepository = factory.getRepository(GradeRepository.class);
		CommentRepository cRepository = factory.getRepository(CommentRepository.class);
		StatusRepository sRepository = factory.getRepository(StatusRepository.class);
		return (args) -> {
			gRepository.save(new Grade("1", "31", "1", "4"));
			cRepository.save(new Comment("1", "33", "12", "This is my first comment."));
			sRepository.save(new Status("1", "5", "1", "Going"));

			System.out.println("Grade found with findByUserID('31'):");
			System.out.println("--------------------------------------------");
			gRepository.findByUserID("31").forEach(grade -> {
				System.out.println(grade.toString());
			});
			
			System.out.println("Comment found with findByUserID('33'):");
			System.out.println("--------------------------------------------");
			cRepository.findByUserID("31").forEach(comment -> {
				System.out.println(comment.toString());
			});
			
			System.out.println("Status found with findByUserID('5'):");
			System.out.println("--------------------------------------------");
			sRepository.findByUserID("31").forEach(status -> {
				System.out.println(status.toString());
			});
		};
	}
}