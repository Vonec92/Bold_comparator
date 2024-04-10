package be.bebold.digital.recommender.bbrecommenderbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class of the application
 * when running the application, you can http://localhost:8080/swagger-ui/index.html for the swagger documentation
 * 
 */
@SpringBootApplication
public class BbrecommenderbeApplication {

	/***
	 * Main method of the application
	 * @param args the arguments of the application
	 */
	public static void main(String[] args) {

		SpringApplication.run(BbrecommenderbeApplication.class, args);
	}

}
