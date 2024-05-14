package com.practice.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book_for_sale")
public class BookForSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
    private String author;
    private String isbn;
}
