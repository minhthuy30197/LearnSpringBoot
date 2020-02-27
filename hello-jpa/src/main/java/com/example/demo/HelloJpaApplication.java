package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@AllArgsConstructor
public class HelloJpaApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(HelloJpaApplication.class, args);
	}

	private PersonRepository personRepository;
	private IdentityCardRepository identityCardRepository;
	private OrderRepository orderRepository;
	private DocumentRepository documentRepository;
	private CarRepository carRepository;

	@Override
	public void run(String... args) throws Exception {
		// Tạo object IdentityCard
		IdentityCard idc = new IdentityCard();
		idc.setId("ABC123");
		idc.setExpired(new Date());
		idc.setIssued(new Date());

		// Lưu idc vào database
		identityCardRepository.save(idc);

        // Tạo object Person
        Person person = new Person();
        person.setEmail("abc@gmail.com");
        person.setFullName("abc");
        person.setPassword("123");
        person.setIdentityCard(idc);

        // Lưu user vào database
		personRepository.save(person);

		// Tạo object Order
		Order order = new Order();
		order.setTotalMoney(500000);
		order.setPerson(person);

		// Lưu order vào database
		orderRepository.save(order);

		// Tạo object Document
		Document document = new Document();
		document.setTitle("Introduction to Java");
		List<Person> authors = new ArrayList<Person>();
		authors.add(person);
		document.setAuthors(authors);

		// Lưu document vào database
		documentRepository.save(document);

		// Lấy kết quả
		Optional<Person> rs = personRepository.findById(1);
		System.out.println(rs.get().toString());

		Optional<Order> rs1 = orderRepository.findById(1);
		System.out.println(rs1.get().toString());

		Optional<Document> rs2 = documentRepository.findById(1);
		System.out.println(rs2.get().toString());

		Car car = new Car();
		car.setName("Ford Tourneo Titanium");
		ArrayList<String> images = new ArrayList<String>();
		images.add("img1.jpg");
		images.add("img2.jpg");
		car.setImages(images);
		Car.Engine engine = new Car.Engine(220, "2.0 ecoboots");
		car.setEngine(engine);

		carRepository.save(car);

		Optional<Car> getCar = carRepository.findById(1);
		System.out.println(getCar.get().toString());
	}
}
