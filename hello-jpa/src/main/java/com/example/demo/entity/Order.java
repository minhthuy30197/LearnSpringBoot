package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="total_money")
    private float totalMoney;

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;
}
