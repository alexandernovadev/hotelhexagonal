package com.hotels.mart.application.services.profession;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Profession;
import com.hotels.mart.infrastructure.jpa.repositories.ProfessionRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
@Service
public class GetProfessionByIdService {
  @Autowired
  private ProfessionRepository professionRepository;

  public Optional<Profession> getProfessionById(Integer id) {
    return professionRepository.findById(id);
  }
  
}







