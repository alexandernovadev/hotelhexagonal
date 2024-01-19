package com.hotels.mart.application.services.sex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Sex;
import com.hotels.mart.infrastructure.jpa.repositories.SexRepository;

@Service
public class CreateSexService {
  @Autowired
  private SexRepository sexRepository;

  public void createSex(Sex sex) {
    sexRepository.save(sex);
  }

}
