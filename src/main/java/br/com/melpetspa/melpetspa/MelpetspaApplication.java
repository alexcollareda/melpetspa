package br.com.melpetspa.melpetspa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MelpetspaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MelpetspaApplication.class, args);
	}

}