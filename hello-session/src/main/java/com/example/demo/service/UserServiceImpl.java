package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.DuplicateRecordException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.dto.UserSession;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.model.request.AuthenticateReq;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

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

    public UserSession login(AuthenticateReq loginReqest) {
        // Lấy thông tin user
        User user = userRepository.findByEmail(loginReqest.getEmail());
        if (user == null) {
            throw new NotFoundException("Email does not exist in the system");
        }

        // Kiểm tra password
        boolean result = BCrypt.checkpw(loginReqest.getPassword(), user.getPassword());
        if (!result) {
            throw new BadRequestException("Password wrong");
        }

        return UserMapper.toUserSession(user);
    }
}
