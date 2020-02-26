package com.example.demo.entity;

import lombok.*;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class BookId implements Serializable {
    private int bookId;

    private String isbn;
}
