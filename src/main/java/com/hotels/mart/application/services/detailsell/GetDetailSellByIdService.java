package com.hotels.mart.application.services.detailsell;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.DetailSell;
import com.hotels.mart.infrastructure.jpa.repositories.DetailSellRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
@Service
public class GetDetailSellByIdService {
  @Autowired
  private DetailSellRepository detailsellRepository;

  public Optional<DetailSell> getDetailSellById(Integer id) {
    return detailsellRepository.findById(id);
  }
  
}







