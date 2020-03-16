package com.example.demo;

import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

public class TestAnnotationTestConfiguration {
    @TestConfiguration
    public static class UserServiceTest2Configuration{
        @Bean
        UserService todoService(){
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserService userService;
}
