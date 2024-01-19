package com.hotels.mart.application.services.detailsell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.DetailSell;
import com.hotels.mart.infrastructure.jpa.repositories.DetailSellRepository;

@Service
public class CreateDetailSellService {
  @Autowired
  private DetailSellRepository detailsellRepository;

  public void createDetailSell(DetailSell detailsell) {
    detailsellRepository.save(detailsell);
  }

}
