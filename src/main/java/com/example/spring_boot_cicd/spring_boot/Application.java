package com.example.spring_boot_cicd.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "hello";
	}

	@GetMapping("/welcome")
	public String hello1() {
		return "hello welcome";
	}

	/*
	 * git init
	 * git add README.md
	 * git commit -m "first commit"
	 * git branch -M main
	 * git remote add origin
	 * https://github.com/Manish254252/Spring-boot-CI-CD-Example.git
	 * git push -u origin main
	 */

}
