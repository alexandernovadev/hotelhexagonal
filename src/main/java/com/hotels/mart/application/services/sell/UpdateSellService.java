package com.hotels.mart.application.services.sell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Sell;
import com.hotels.mart.infrastructure.jpa.repositories.SellRepository;

@Service
public class UpdateSellService {
  
  @Autowired
  private SellRepository uexRepository;

  public void updateSell(Sell uex) {
    uexRepository.save(uex);
  }
}