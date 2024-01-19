package com.hotels.mart.application.services.sell;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Sell;
import com.hotels.mart.infrastructure.jpa.repositories.SellRepository;

@Service
public class GetAllSellService {
  @Autowired
  private SellRepository sellRepository;

  public  List<Sell> getAllSells() {
    return sellRepository.findAll();
  }
}
