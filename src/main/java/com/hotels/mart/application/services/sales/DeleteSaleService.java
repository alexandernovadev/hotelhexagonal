package com.hotels.mart.application.services.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.infrastructure.jpa.repositories.SalesRepository;

@Service
public class DeleteSaleService {
  @Autowired
  private SalesRepository salesRepository;

  public void deleteSale(Long id) {
    salesRepository.deleteById(id);
  }
}
