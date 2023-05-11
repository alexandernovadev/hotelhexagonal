package com.hotels.mart.application.services.traceability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hotels.mart.application.strategies.TraceabilityStrategy;
import com.hotels.mart.domain.entities.Traceability;
import com.hotels.mart.infrastructure.jpa.repositories.TraceabilityRepository;

@Service
public class GotraceabilityService {

  @Autowired
  @Qualifier("saveToDatabaseStrategy")
  private TraceabilityStrategy traceabilityStrategy;

  public void saveAuditory(Traceability traceability) {
    traceabilityStrategy.execute(traceability);
  }

  public void setTraceabilityStrategy(TraceabilityStrategy traceabilityStrategy) {
    this.traceabilityStrategy = traceabilityStrategy;
  }
}
