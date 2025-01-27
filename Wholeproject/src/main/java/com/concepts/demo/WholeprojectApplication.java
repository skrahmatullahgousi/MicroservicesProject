package com.concepts.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WholeprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WholeprojectApplication.class, args);
	}

}
