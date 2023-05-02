package com.hotels.mart.application.services.sales;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Sale;
import com.hotels.mart.infrastructure.jpa.repositories.SalesRepository;

@Service
public class GetSaleByIdService {

  @Autowired
  private SalesRepository salesRepository;

  public Optional<Sale> getSaleById(Long id) {
    return salesRepository.findById(id);
  }
}
