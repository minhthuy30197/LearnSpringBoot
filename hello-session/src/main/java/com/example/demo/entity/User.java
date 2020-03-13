package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(name="email", unique = true)
    private String email;

    @Column(name="phone", length = 11)
    private String phone;

    @Column(name="password")
    private String password;

    @Column(name="name")
    private String name;

    @Column(name="avatar")
    private String avatar;

    @Column(name="birthday")
    private Date birthday;

    @Column(name = "role", nullable = false, columnDefinition = "varchar(255) default 'USER'")
    private String role;
}
