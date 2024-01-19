package com.hotels.mart.application.services.city;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.City;
import com.hotels.mart.infrastructure.jpa.repositories.CityRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
@Service
public class GetCityByIdService {
  @Autowired
  private CityRepository cityRepository;

  public Optional<City> getCityById(Integer id) {
    return cityRepository.findById(id);
  }
  
}







