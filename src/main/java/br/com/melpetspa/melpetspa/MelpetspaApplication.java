package br.com.melpetspa.melpetspa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableJpaRepositories
public class MelpetspaApplication {

	public static void main(String[] args) {
		ZoneId cuiabaZone = ZoneId.of("America/Cuiaba");
		ZonedDateTime nowInCuiaba = ZonedDateTime.now(cuiabaZone);
		System.out.println("Hora atual em Cuiabá (para registrar ou exibir): " + nowInCuiaba);

		// 2. Se você tem um Instant (UTC, geralmente do banco de dados) e quer exibir em Cuiabá
		Instant storedInstant = Instant.now(); // Simula um Instant salvo em UTC
		System.out.println("Instant (UTC) salvo: " + storedInstant);

		ZonedDateTime displayedInCuiaba = storedInstant.atZone(cuiabaZone);
		System.out.println("Instant exibido em Cuiabá: " + displayedInCuiaba);

		// Formatação para exibição
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		System.out.println("Instant formatado em Cuiabá: " + displayedInCuiaba.format(formatter));
		SpringApplication.run(MelpetspaApplication.class, args);
	}

}