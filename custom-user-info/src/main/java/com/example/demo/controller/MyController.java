package com.example.demo.controller;

import com.example.demo.security.IsAdmin;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.security.RolesAllowed;

@RestController
public class MyController {
    @GetMapping("/hello")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile() {
        return ResponseEntity.ok("Profile");
    }

    @GetMapping("/current-user")
    public ResponseEntity<?> getCurrentUser() {
        return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/blog")
    public ResponseEntity<?> blog() {
        return ResponseEntity.ok("Blog");
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/shop")
    public ResponseEntity<?> shop() {
        return ResponseEntity.ok("Shop");
    }

    @IsAdmin
    @GetMapping("/home")
    public ResponseEntity<?> home() {
        return ResponseEntity.ok("Home");
    }
}