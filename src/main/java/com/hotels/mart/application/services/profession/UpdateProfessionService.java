package com.hotels.mart.application.services.profession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Profession;
import com.hotels.mart.infrastructure.jpa.repositories.ProfessionRepository;

@Service
public class UpdateProfessionService {
  
  @Autowired
  private ProfessionRepository uexRepository;

  public void updateProfession(Profession uex) {
    uexRepository.save(uex);
  }
}