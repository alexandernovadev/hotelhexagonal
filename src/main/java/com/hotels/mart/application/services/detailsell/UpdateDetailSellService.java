package com.hotels.mart.application.services.detailsell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.DetailSell;
import com.hotels.mart.infrastructure.jpa.repositories.DetailSellRepository;

@Service
public class UpdateDetailSellService {
  
  @Autowired
  private DetailSellRepository uexRepository;

  public void updateDetailSell(DetailSell uex) {
    uexRepository.save(uex);
  }
}