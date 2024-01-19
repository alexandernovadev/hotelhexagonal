package com.hotels.mart.application.services.detailsell;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.DetailSell;
import com.hotels.mart.infrastructure.jpa.repositories.DetailSellRepository;

@Service
public class GetAllDetailSellService {
  @Autowired
  private DetailSellRepository detailsellRepository;

  public  List<DetailSell> getAllDetailSells() {
    return detailsellRepository.findAll();
  }
}
