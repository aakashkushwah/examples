package com.akushwah.example.democors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.akushwah.example.democors",
		"com.akushwah.example.democors.controller" })
public class DemoCorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCorsApplication.class, args);
	}

	

}
