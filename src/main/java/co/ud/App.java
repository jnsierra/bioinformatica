package co.ud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"co.ud.repository"})
public class App {
	
	public static void main(String ...args) {
		SpringApplication.run(App.class, args);
	}
}
