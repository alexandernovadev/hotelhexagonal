package com.hotels.mart.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment_methods")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentMethod {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long payment_method_id;

  private String method_name;
}
