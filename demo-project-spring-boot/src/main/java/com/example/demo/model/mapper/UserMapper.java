package com.example.demo.model.mapper;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateUserRequest;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setAvatar(user.getAvatar());
        userDto.setEmail(user.getEmail());
        userDto.setBirthday(user.getBirthday());
        userDto.setFullname(user.getFullname());
        userDto.setId(user.getId());
        userDto.setPhone(user.getPhone());
        return userDto;
    }

    public static User toUser(CreateUserRequest req) {
        User user = new User();
        user.setFullname(req.getFullName());
        user.setAvatar(req.getAvatar());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        user.setBirthday(req.getBirthday());
        String hash = BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hash);

        return user;
    }
}
