package com.hotels.mart.application.services.sales.salesState;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.SalesState;
import com.hotels.mart.infrastructure.jpa.repositories.SalesStateRepository;

@Service
public class GetSaleStateByIdService {

  @Autowired
  private SalesStateRepository salesStateRepository;

  public Optional<SalesState> getSaleStateById(Long Id) {

    return salesStateRepository.findById(Id);
  }
}
