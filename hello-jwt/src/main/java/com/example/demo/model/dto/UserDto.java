package com.example.demo.model.dto;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;

    private String name;

    private String email;

    private String phone;

    private String avatar;

    private Date birthday;
}
