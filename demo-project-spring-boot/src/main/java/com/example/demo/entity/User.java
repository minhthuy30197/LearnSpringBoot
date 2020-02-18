package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(name="email", unique = true)
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="password")
    private String password;

    @Column(name="fullname")
    private String fullname;

    @Column(name="avatar")
    private String avatar;

    @Column(name="birthday")
    private Date birthday;

    @Column(name = "role", nullable = false)
    private String role;
}
