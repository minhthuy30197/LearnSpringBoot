package com.company.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HelloComponentApplication {
	public static void main(String[] args) {
        // ApplicationContext chính là container có context chứa toàn bộ các Bean
		ApplicationContext context = SpringApplication.run(HelloComponentApplication.class, args);

        // Khi chạy xong, lúc này context sẽ chứa các Bean có đánh dấu @Component

        // Lấy Bean ra bằng cách
		Outfit outfit = context.getBean(Outfit.class);

		System.out.println("Instance: " + outfit);
		outfit.wear();
	}
}
