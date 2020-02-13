package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HelloScopeApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HelloScopeApplication.class, args);

		Dress dress1 = context.getBean(Dress.class);
		Dress dress2 = context.getBean(Dress.class);

		System.out.println("Dress 1: "+ dress1);
		System.out.println("Dress 2: "+ dress2);
	}
}
