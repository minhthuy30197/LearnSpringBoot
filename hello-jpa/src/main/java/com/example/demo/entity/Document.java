package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="title")
    private String title;

    @ManyToMany
    @JoinTable(
            name = "author",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "document_id")
    )
    @ToString.Exclude
    private List<Person> authors;
}
