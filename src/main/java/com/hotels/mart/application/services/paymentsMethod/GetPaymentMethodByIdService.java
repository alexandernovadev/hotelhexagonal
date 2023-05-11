package com.hotels.mart.application.services.paymentsMethod;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.PaymentMethod;
import com.hotels.mart.infrastructure.jpa.repositories.PaymentMethodRepository;

@Service
public class GetPaymentMethodByIdService {

  @Autowired
  private PaymentMethodRepository paymentMethodRepository;

  public Optional<PaymentMethod> getPaymentMethodByID(Long Id) {
    return paymentMethodRepository.findById(Id);
  }
}
