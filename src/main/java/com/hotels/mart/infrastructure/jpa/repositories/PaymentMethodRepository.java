package com.hotels.mart.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotels.mart.domain.entities.PaymentMethod;

@Repository
public interface PaymentMethodRepository  extends JpaRepository<PaymentMethod, Long>{
  
}
