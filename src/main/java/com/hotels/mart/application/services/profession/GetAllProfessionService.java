package com.hotels.mart.application.services.profession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Profession;
import com.hotels.mart.infrastructure.jpa.repositories.ProfessionRepository;

@Service
public class GetAllProfessionService {
  @Autowired
  private ProfessionRepository professionRepository;

  public  List<Profession> getAllProfessions() {
    return professionRepository.findAll();
  }
}
