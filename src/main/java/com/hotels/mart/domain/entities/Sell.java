package com.hotels.mart.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Sell")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sell {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sell_id")
  private Integer sell_id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "balance")
  private BigDecimal balance;

  @Column(name = "state", length = 50)
  private String state;

  @Column(name = "created_at")
  private LocalDateTime created_at;
}
