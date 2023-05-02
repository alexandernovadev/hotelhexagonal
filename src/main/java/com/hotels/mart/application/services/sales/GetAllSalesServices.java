package com.hotels.mart.application.services.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Sale;
import com.hotels.mart.infrastructure.jpa.repositories.SalesRepository;

@Service
public class GetAllSalesServices {

  @Autowired
  private SalesRepository salesRepository;

  public List<Sale> getAllSales() {
    return salesRepository.findAll();
  }

}
