package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.model.request.UpdateUserReq;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public interface UserService {
    public List<UserDto> getListUser();

    public Page<User> findUserLikeName(String name, int page);

    public UserDto getUserById(int id);

    public UserDto createUser(CreateUserReq req);

    public UserDto updateUser(UpdateUserReq req, int id);

    public void deleteUser(int id);

    @Transactional
    public void testTransaction();
}
