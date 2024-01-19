package com.hotels.mart.application.services.sex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.infrastructure.jpa.repositories.SexRepository;

@Service
public class DeleteSexService {
  @Autowired
  private SexRepository sexRepository;

  public void deleteSex(Integer id) {
    sexRepository.deleteById(id);
  }
}
