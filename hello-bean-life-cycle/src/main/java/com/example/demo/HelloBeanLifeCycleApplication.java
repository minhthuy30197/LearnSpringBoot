package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloBeanLifeCycleApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HelloBeanLifeCycleApplication.class, args);

		System.out.println("Before get Bean Dress");

		Dress dress = context.getBean(Dress.class);

		System.out.println(dress);
		dress.wear();

		((ConfigurableApplicationContext) context).getBeanFactory().destroyBean(dress);
	}
}
