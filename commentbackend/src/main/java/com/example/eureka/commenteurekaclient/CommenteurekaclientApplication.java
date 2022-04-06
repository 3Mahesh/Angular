package com.example.eureka.commenteurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
@ComponentScan(basePackages="com.example.eureka.commenteurekaclient")
@CrossOrigin(value="http://localhost:4200")
public class CommenteurekaclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommenteurekaclientApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
