package mx.unam.dgtic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@EnableMongoRepositories(basePackages = "mx.unam.dgtic")
public class M800Application {

	public static void main(String[] args) {
		SpringApplication.run(M800Application.class, args);
	}

}
