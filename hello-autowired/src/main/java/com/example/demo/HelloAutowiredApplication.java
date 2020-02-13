package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HelloAutowiredApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HelloAutowiredApplication.class, args);

		GirlFriend girlFriend = context.getBean(GirlFriend.class);

		System.out.println("Instance girlfriend: " + girlFriend);
		System.out.println("Outfit of girlfriend: " + girlFriend.outfit);
		girlFriend.outfit.wear();
	}
}
