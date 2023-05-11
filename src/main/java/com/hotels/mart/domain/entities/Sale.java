package com.hotels.mart.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sales")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sale {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long sales_id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @OneToOne
  @JoinColumn(name = "reservation_id")
  private Reservation reservation;

  @ManyToOne
  @JoinColumn(name = "sales_state_id")
  private SalesState sales_state;

  @ManyToOne
  @JoinColumn(name = "payment_method_id")
  private PaymentMethod payment_method;
}
