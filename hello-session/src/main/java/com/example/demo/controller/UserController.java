package com.example.demo.controller;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.dto.UserSession;
import com.example.demo.model.request.AuthenticateReq;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public ResponseEntity<?> getProfile() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser( @RequestBody CreateUserReq req) {
        UserDto result = userService.createUser(req);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> login(@Valid @RequestBody AuthenticateReq req, HttpSession session) {
        UserSession result = userService.login(req);

        // Result is token. Set session.
        session.setAttribute("TECHMASTER_SESSION", result);

        return ResponseEntity.ok("Đăng nhập thành công");
    }
}