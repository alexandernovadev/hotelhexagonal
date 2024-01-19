package com.hotels.mart.application.services.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.infrastructure.jpa.repositories.CityRepository;

@Service
public class DeleteCityService {
  @Autowired
  private CityRepository cityRepository;

  public void deleteCity(Integer id) {
    cityRepository.deleteById(id);
  }
}
