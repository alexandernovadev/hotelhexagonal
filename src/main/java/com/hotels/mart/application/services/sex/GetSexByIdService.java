package com.hotels.mart.application.services.sex;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Sex;
import com.hotels.mart.infrastructure.jpa.repositories.SexRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
@Service
public class GetSexByIdService {
  @Autowired
  private SexRepository sexRepository;

  public Optional<Sex> getSexById(Integer id) {
    return sexRepository.findById(id);
  }
  
}







