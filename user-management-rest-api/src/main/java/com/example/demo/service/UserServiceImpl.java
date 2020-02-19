package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
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
        UserDto user = new UserDto();

        // Lọc

        return user;
    }
}
