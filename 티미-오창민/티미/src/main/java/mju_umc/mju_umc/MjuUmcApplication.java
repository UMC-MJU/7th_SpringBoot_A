package mju_umc.mju_umc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class MjuUmcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MjuUmcApplication.class, args);
	}

}

