package com.hotels.mart.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotels.mart.domain.entities.PaymentMethod;

public interface PaymentMethodRepository  extends JpaRepository<PaymentMethod, Long>{
  
}
