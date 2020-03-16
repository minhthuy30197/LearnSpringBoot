package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Date;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testTodoRepositoryByCode() {
        userRepository.save(new User(1, "mongmo@gmail.com", "0987654321", "1234", "Nguyễn Thị Mộng Mơ", "img1.jpg", new Date(), "USER"));
        userRepository.save(new User(2, "lunglinh@gmail.com", "0916164946", "abcd", "Phan Thị Lung Linh", "img2.jpg", new Date(), "USER"));

        Assert.assertEquals(2, userRepository.findAll().size());
        Assert.assertEquals("mongmo@gmail.com", userRepository.findById(1).get().getEmail());
    }

    @AfterEach
    public void clean() {
        userRepository.deleteAll();
    }
}
