package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="car")
@TypeDef(
        name = "json",
        typeClass = JsonStringType.class
)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @Type(type = "json")
    @Column(name = "images", columnDefinition = "json")
    private ArrayList<String> images;

    @Type(type = "json")
    @Column(name = "engine", columnDefinition = "json")
    private Engine engine;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Engine implements Serializable {
        private int cc;

        private String type;
    }
}
