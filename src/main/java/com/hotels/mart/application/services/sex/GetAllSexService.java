package com.hotels.mart.application.services.sex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Sex;
import com.hotels.mart.infrastructure.jpa.repositories.SexRepository;

@Service
public class GetAllSexService {
  @Autowired
  private SexRepository sexRepository;

  public  List<Sex> getAllSexs() {
    return sexRepository.findAll();
  }
}
