package com.wellsfargo.onlinebanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@CrossOrigin("http://localhost:3000")
public class OnlinebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinebankingApplication.class, args);
		System.out.println("Running Online Banking System");
	}
}
