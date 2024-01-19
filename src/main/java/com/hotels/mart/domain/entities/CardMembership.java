package com.hotels.mart.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Card_Membership")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardMembership {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "card_id")
  private Integer card_id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "balance")
  private BigDecimal balance;

  @Column(name = "created_at")
  private LocalDateTime created_at;
}
