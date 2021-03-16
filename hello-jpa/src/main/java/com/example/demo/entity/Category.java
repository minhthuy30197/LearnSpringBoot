package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name", length = 200)
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Course> courses;
}
