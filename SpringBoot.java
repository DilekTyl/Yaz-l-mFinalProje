package com.spring.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 1-) Run as Java application

// 2-) Maven Build : goal kısmına "spring-boot:run"
@SpringBootApplication
public class SpringBoot{

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot.class, args);
	}
}