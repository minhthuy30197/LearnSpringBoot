package com.example.demo.service;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.model.request.UpdateUserReq;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getListUser() {
        return null;
    }

    @Override
    public UserDto getUserById(int id) {
        return null;
    }

    @Override
    public UserDto createUser(CreateUserReq req) {
        return null;
    }

    @Override
    public UserDto updateUser(UpdateUserReq req, int id) {
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }
}
