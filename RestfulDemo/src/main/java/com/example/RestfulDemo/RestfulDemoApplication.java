package com.example.RestfulDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RestfulDemoApplication {

	public static void main(String[] args) {
		
		System.out.println("**** Demo API ****");
		SpringApplication.run(RestfulDemoApplication.class, args);
		
	}
}
