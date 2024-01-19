package com.hotels.mart.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Detail_Sell")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetailSell {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "detail_sell_id")
  private Integer detail_sell_id;

  @ManyToOne
  @JoinColumn(name = "sell_id")
  private Sell sell;

  @ManyToOne
  @JoinColumn(name = "book_id")
  private Book book;

  @Column(name = "amount")
  private Integer amount;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "created_at")
  private LocalDateTime created_at;
}
