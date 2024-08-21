package com.example.githubservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GithubServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GithubServiceApplication.class, args);
	}

}
