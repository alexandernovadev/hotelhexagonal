package com.hotels.mart.application.services.traceability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Traceability;
import com.hotels.mart.infrastructure.jpa.repositories.TraceabilityRepository;

@Service
public class GotraceabilityService {

  @Autowired
  private TraceabilityRepository traceabilityRepository;

  public void saveAuditory(Traceability traceability) {
    traceabilityRepository.save(traceability);
  }
}
