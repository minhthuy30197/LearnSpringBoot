package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.repository.*;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

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
	private UserServiceImpl userService;
	private CategoryRepository categoryRepository;
	private CourseRepository courseRepository;

	@Override
	public void run(String... args) throws Exception {
		courseRepository.deleteAll();
		categoryRepository.deleteAll();

		Category category1 = Category.builder().name("KHTN").build();
		Category category2 = Category.builder().name("XH").build();
		categoryRepository.saveAll(Arrays.asList(category1, category2));

		Course course1 = Course.builder().title("Toan").category(category1).build();
		Course course2 = Course.builder().title("Hoa").category(category1).build();
		Course course3 = Course.builder().title("Van").category(category1).build();
		courseRepository.saveAll(Arrays.asList(course1, course2, course3));

		// Test insert dữ liệu vào các bảng có quan hệ
//		// Tạo object IdentityCard
//		IdentityCard idc = new IdentityCard();
//		idc.setId("ABC123");
//		idc.setExpired(new Date());
//		idc.setIssued(new Date());
//
//		// Lưu idc vào database
//		identityCardRepository.save(idc);
//
//        // Tạo object Person
//        Person person = new Person();
//        person.setEmail("abc@gmail.com");
//        person.setFullName("abc");
//        person.setPassword("123");
//        person.setIdentityCard(idc);
//
//        // Lưu user vào database
//		personRepository.save(person);
//
//		// Tạo object Order
//		Order order = new Order();
//		order.setTotalMoney(500000);
//		order.setPerson(person);
//
//		// Lưu order vào database
//		orderRepository.save(order);
//
//		// Tạo object Document
//		Document document = new Document();
//		document.setTitle("Introduction to Java");
//		List<Person> authors = new ArrayList<Person>();
//		authors.add(person);
//		document.setAuthors(authors);
//
//		// Lưu document vào database
//		documentRepository.save(document);
//
//		// Lấy kết quả
//		Optional<Person> rs = personRepository.findById(1);
//		System.out.println(rs.get().toString());
//
//		Optional<Order> rs1 = orderRepository.findById(1);
//		System.out.println(rs1.get().toString());
//
//		Optional<Document> rs2 = documentRepository.findById(1);
//		System.out.println(rs2.get().toString());
//
//		Car car = new Car();
//		car.setName("Ford Tourneo Titanium");
//		ArrayList<String> images = new ArrayList<String>();
//		images.add("img1.jpg");
//		images.add("img2.jpg");
//		car.setImages(images);
//		Car.Engine engine = new Car.Engine(220, "2.0 ecoboots");
//		car.setEngine(engine);
//
//		carRepository.save(car);
//
//		Optional<Car> getCar = carRepository.findById(1);
//		System.out.println(getCar.get().toString());
	}
}
