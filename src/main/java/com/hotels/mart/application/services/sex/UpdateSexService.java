package com.hotels.mart.application.services.sex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Sex;
import com.hotels.mart.infrastructure.jpa.repositories.SexRepository;

@Service
public class UpdateSexService {
  
  @Autowired
  private SexRepository uexRepository;

  public void updateSex(Sex uex) {
    uexRepository.save(uex);
  }
}