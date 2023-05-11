package com.hotels.mart.application.services.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Sale;
import com.hotels.mart.infrastructure.jpa.repositories.SalesRepository;

@Service
public class UpdateSalesService {
  
  @Autowired
  private SalesRepository salesRepository;

  public void updateRoom(Sale room) {
    salesRepository.save(room);
  }

}
