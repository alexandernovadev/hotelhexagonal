package com.hotels.mart.application.services.detailsell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.infrastructure.jpa.repositories.DetailSellRepository;

@Service
public class DeleteDetailSellService {
  @Autowired
  private DetailSellRepository detailsellRepository;

  public void deleteDetailSell(Integer id) {
    detailsellRepository.deleteById(id);
  }
}
