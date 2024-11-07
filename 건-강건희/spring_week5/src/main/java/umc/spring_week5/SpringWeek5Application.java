package umc.spring_week5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringWeek5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringWeek5Application.class, args);
	}

}
