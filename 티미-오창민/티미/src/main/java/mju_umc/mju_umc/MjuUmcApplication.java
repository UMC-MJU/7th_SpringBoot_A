package mju_umc.mju_umc;

import mju_umc.mju_umc.domain.Store;
import mju_umc.mju_umc.service.StoreQueryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;


@SpringBootApplication
@EnableJpaAuditing
public class MjuUmcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MjuUmcApplication.class, args);
	}


	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			StoreQueryService storeService = context.getBean(StoreQueryService.class);

			// 파라미터 값 설정
			String name = "요아정";
			Float score = 4.0f;

			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
			System.out.println("Executing findStoresByNameAndScore with parameters:");
			System.out.println("Name: " + name);
			System.out.println("Score: " + score);


			List<Store> storesByNameAndScore = storeService.findStoresByNameAndScore(name, score);
			for (Store s : storesByNameAndScore) {
				System.out.println(s.toString());
			}
		};
	}}

