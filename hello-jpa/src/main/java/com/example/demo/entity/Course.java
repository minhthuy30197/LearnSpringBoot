package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="title", length = 200)
    private String title;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
}
