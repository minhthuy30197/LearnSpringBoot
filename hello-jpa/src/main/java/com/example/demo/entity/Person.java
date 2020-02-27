package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(name="email", unique = true)
    private String email;

    @Column(name="full_name")
    private String fullName;

    @Column(name="password")
    private String password;

    @OneToOne
    @JoinColumn(name = "identity_card_id")
    private IdentityCard identityCard;

    @OneToMany(mappedBy = "person")
    @ToString.Exclude
    private List<Order> orders;
}
