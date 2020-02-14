package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HelloPrimaryQualifierApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HelloPrimaryQualifierApplication.class, args);

		GirlFriend girlFriend = context.getBean(GirlFriend.class);

		System.out.println("GirlFriend: " + girlFriend);
		System.out.println("Outfit of girlfriend: " + girlFriend.outfit);
	}
}
