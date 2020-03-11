package com.example.demo.controller;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.AuthenticateReq;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.security.JwtTokenUtil;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

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
    public ResponseEntity<?> login(@Valid @RequestBody AuthenticateReq req) {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(req.getEmail());

            // Kiểm tra username và password
            if (req.getEmail().equals(userDetails.getUsername()) && BCrypt.checkpw(req.getPassword(), userDetails.getPassword())) {
                // Gen token
                String token = jwtTokenUtil.generateToken(userDetails);

                return ResponseEntity.ok(token);
            }

            throw new BadRequestException("Wrong info");
        } catch (UsernameNotFoundException ex) {
            throw new NotFoundException("Email does not exist in system");
        }
    }
}