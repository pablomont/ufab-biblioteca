package com.ufab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"br.uepb.edu.ufab"})// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class RestApiApp {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApp.class, args);
	}
}
