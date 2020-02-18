package com.example.demo.service;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateUserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserDto createUser(CreateUserRequest createUserRequest);
}
