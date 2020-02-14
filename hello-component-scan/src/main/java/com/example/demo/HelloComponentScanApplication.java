package com.example.demo;

import com.example.demo.other_package.Bikini;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

// @ComponentScan({"com.example.demo.other_package"})
@SpringBootApplication(scanBasePackages = {"com.example.demo.other_package"})
public class HelloComponentScanApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HelloComponentScanApplication.class, args);

		Bikini bikini = context.getBean(Bikini.class);
		System.out.println("Bikini: " + bikini);

		Dress dress = context.getBean(Dress.class);
		System.out.println("Dress: " + dress);
	}
}
