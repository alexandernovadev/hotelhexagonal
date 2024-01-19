package com.hotels.mart.application.services.profession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.infrastructure.jpa.repositories.ProfessionRepository;

@Service
public class DeleteProfessionService {
  @Autowired
  private ProfessionRepository professionRepository;

  public void deleteProfession(Integer id) {
    professionRepository.deleteById(id);
  }
}
