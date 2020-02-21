package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.DuplicateRecordException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.model.request.CreateUserReq;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private static ArrayList<User> users = new ArrayList<User>();

    static {
        users.add(new User(1, "Nguyễn Thị Mộng Mơ", "mongmo@gmail.com","0987654321","avatar.img","123"));
        users.add(new User(2, "Bùi Như Lạc", "laclac@gmail.com","0123456789","avatar1.img","123"));
        users.add(new User(3, "Phan Thị Lỏng Lẻo", "longleo@gmail.com","0987564664","avatar3.img","123"));
        users.add(new User(4, "Bành Thị Tèo", "teo@gmail.com","0874845455","avatar9.img","123"));
    }

    @Override
    public List<UserDto> getListUser() {
        ArrayList<UserDto> result = new ArrayList<UserDto>();

        // Convert users -> result
        for (User user : users) {
            result.add(UserMapper.toUserDto(user));
        }

        return result;
    }

    @Override
    public UserDto getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return UserMapper.toUserDto(user);
            }
        }

        throw new NotFoundException("No user found");
    }

    @Override
    public UserDto createUser(CreateUserReq req) {
        // Check email exist
        for (User user : users) {
            if (user.getEmail().equals(req.getEmail())) {
               throw new DuplicateRecordException("Email already exists in the system");
            }
        }

        // Convert CreateUserReq -> User
        User user = UserMapper.toUser(req);
        user.setId(users.size()+1);

        // Insert user
        users.add(user);

        return UserMapper.toUserDto(user);
    }
}
