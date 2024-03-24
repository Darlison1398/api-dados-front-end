package com.example.drsilva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DrsilvaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrsilvaApplication.class, args);
	}

}
