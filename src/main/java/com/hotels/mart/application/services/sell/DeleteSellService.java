package com.hotels.mart.application.services.sell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.infrastructure.jpa.repositories.SellRepository;

@Service
public class DeleteSellService {
  @Autowired
  private SellRepository sellRepository;

  public void deleteSell(Integer id) {
    sellRepository.deleteById(id);
  }
}
