package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(OrderDetailId.class)
@Table(name="order_detail")
public class OrderDetail {
    @Id
    @Column(name="order_id")
    public int orderId;

    @Id
    @Column(name="product_id")
    public int productId;

    @Column(name="quantity", nullable = false)
    private int quantity;

    @Column(name="price", nullable = false)
    private float price;

    @Column(name="amount", nullable = false)
    private float amount;
}
