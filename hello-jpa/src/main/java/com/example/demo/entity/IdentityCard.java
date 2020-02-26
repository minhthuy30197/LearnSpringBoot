package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="identity_card")
public class IdentityCard {
    @Id
    private String id;

    @Column(name="expired")
    private Date expired;

    @Column(name="issued")
    private Date issued;

    @OneToOne( mappedBy = "identityCard")
    private Person person;
}
