package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne // Đánh dấu có mỗi quan hệ 1-1 với IdentityCard
    @JoinColumn(name = "identity_card_id") // Liên kết với nhau qua khóa ngoại identity_card_id
    private IdentityCard identityCard;

    @OneToMany(mappedBy = "person")
    private List<Order> orders;

    @ManyToMany(mappedBy = "authors")
    private List<Document> documents;
}
