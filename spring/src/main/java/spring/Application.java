package spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import spring.dao.ClassRepository;
import spring.dao.StudentClassRepository;
import spring.model.StudentClass;
import spring.model.StudentClassPK;

/**
 * Main Spring Boot Application class
 * @author Ali Bassam
 *
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/**
	 * Register a RestTemplate Bean as a REST client
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	/**
	 * Run this code at startup to create some data in the database
	 * @param repository
	 * @param studentClassRepository
	 * @return
	 */
	@Bean
	public CommandLineRunner demo(ClassRepository repository, StudentClassRepository studentClassRepository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new spring.model.Class(1, "Math"));
			repository.save(new spring.model.Class(2, "Physics"));
			repository.save(new spring.model.Class(3, "Biology"));
			repository.save(new spring.model.Class(4, "Chemistry"));
			repository.save(new spring.model.Class(5, "Drawing"));
			
			studentClassRepository.save(new StudentClass(new StudentClassPK(1, 1)));
			studentClassRepository.save(new StudentClass(new StudentClassPK(1, 2)));
			studentClassRepository.save(new StudentClass(new StudentClassPK(2, 1)));
			studentClassRepository.save(new StudentClass(new StudentClassPK(2, 4)));
			studentClassRepository.save(new StudentClass(new StudentClassPK(2, 5)));
			studentClassRepository.save(new StudentClass(new StudentClassPK(3, 2)));
			studentClassRepository.save(new StudentClass(new StudentClassPK(3, 3)));
			studentClassRepository.save(new StudentClass(new StudentClassPK(4, 3)));
			studentClassRepository.save(new StudentClass(new StudentClassPK(4, 5)));
			studentClassRepository.save(new StudentClass(new StudentClassPK(5, 5)));
		};
	}

}
