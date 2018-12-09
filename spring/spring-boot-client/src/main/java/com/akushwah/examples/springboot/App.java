package com.akushwah.examples.springboot;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class App {
	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    }
}
