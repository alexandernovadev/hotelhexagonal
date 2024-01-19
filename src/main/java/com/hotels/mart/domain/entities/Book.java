package com.hotels.mart.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Book")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "book_id")
  private Integer book_id;

  @Column(name = "name", length = 255)
  private String name;

  @Column(name = "author", length = 255)
  private String author;

  @Column(name = "ISBN", length = 50)
  private String ISBN;

  @Column(name = "image", length = 255)
  private String image;

  @Column(name = "amount")
  private Integer amount;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "status", length = 50)
  private String status;

  @Column(name = "created_at")
  private LocalDateTime created_at;
}
