package com.hotels.mart.application.services.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.City;
import com.hotels.mart.infrastructure.jpa.repositories.CityRepository;

@Service
public class GetAllCityService {
  @Autowired
  private CityRepository cityRepository;

  public  List<City> getAllCitys() {
    return cityRepository.findAll();
  }
}
