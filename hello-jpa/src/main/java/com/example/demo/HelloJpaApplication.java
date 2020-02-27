package com.example.demo;

import com.example.demo.entity.Document;
import com.example.demo.entity.IdentityCard;
import com.example.demo.entity.Order;
import com.example.demo.entity.Person;
import com.example.demo.repository.DocumentRepository;
import com.example.demo.repository.IdentityCardRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.print.Doc;
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
	}
}
