package com.hotels.mart.application.services.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.City;
import com.hotels.mart.infrastructure.jpa.repositories.CityRepository;

@Service
public class CreateCityService {
  @Autowired
  private CityRepository cityRepository;

  public void createCity(City city) {
    cityRepository.save(city);
  }

}
