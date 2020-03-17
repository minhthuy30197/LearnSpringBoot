package com.example.demo.service;

import com.example.demo.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDto> getListUserByName(String keyword) throws InterruptedException;
}
