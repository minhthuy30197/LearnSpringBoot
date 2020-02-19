package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.DuplicateRecordException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.model.request.CreateUserRequest;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{
        @Autowired
        private UserRepository userRepository;

        public UserDto createUser(CreateUserRequest createUserRequest) {
                // Kiểm tra email đã có trong hệ thống chưa
                User check = userRepository.findByEmail(createUserRequest.getEmail());
                if (check != null) {
                    throw new DuplicateRecordException("Email đã tồn tại trong hệ thống");
                }

        User user = UserMapper.toUser(createUserRequest);
        user.setRole("USER");
        User newUser = userRepository.save(user);
        return UserMapper.toUserDto(newUser);
    }
}
