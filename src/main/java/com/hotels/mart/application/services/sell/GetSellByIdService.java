package com.hotels.mart.application.services.sell;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Sell;
import com.hotels.mart.infrastructure.jpa.repositories.SellRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
@Service
public class GetSellByIdService {
  @Autowired
  private SellRepository sellRepository;

  public Optional<Sell> getSellById(Integer id) {
    return sellRepository.findById(id);
  }
  
}







