package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.DuplicateRecordException;
import com.example.demo.exception.InternalServerException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.model.request.UpdateUserReq;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getListUser() {
        List<User> users = userRepository.findAll();

        List<UserDto> rs = new ArrayList<UserDto>();
        for (User user : users) {
            rs.add(UserMapper.toUserDto(user));
        }

        return rs;
    }

    @Override
    public UserDto getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("No user found");
        }

        return UserMapper.toUserDto(user.get());
    }

    @Override
    public UserDto createUser(CreateUserReq req) {
        // Check email exist
        User user = userRepository.findByEmail(req.getEmail());
        if (user != null) {
            throw new DuplicateRecordException("Email is already in use");
        }

        user = UserMapper.toUser(req);
        userRepository.save(user);

        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto updateUser(UpdateUserReq req, int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("No user found");
        }

        User updateUser = UserMapper.toUser(req, id);
        try {
            userRepository.save(updateUser);
        } catch (Exception ex) {
            throw new InternalServerException("Database error. Can't update user");
        }

        return UserMapper.toUserDto(updateUser);
    }

    @Override
    public void deleteUser(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("No user found");
        }

        try {
            userRepository.deleteById(id);
        } catch (Exception ex) {
            throw new InternalServerException("Database error. Can't delete user");
        }
    }
}
