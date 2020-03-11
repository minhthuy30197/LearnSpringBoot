package com.example.demo.service;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.dto.UserSession;
import com.example.demo.model.request.AuthenticateReq;
import com.example.demo.model.request.CreateUserReq;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserDto createUser(CreateUserReq req);

    public UserSession login(AuthenticateReq loginReqest);
}
