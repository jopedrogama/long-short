package com.cotacoes.longshort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LongShortApplication {

	public static void main(String[] args) {
		SpringApplication.run(LongShortApplication.class, args);
	}
}
