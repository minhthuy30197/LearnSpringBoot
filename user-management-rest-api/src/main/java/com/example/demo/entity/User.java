package com.example.demo.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class User {
    private int id;

    private String name;

    private String email;

    private String phone;

    private String avatar;

    private String password;
}
