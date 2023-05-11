package com.hotels.mart.application.strategies;

import com.hotels.mart.domain.entities.Traceability;
import com.hotels.mart.infrastructure.jpa.repositories.TraceabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveToDatabaseStrategy implements TraceabilityStrategy {

    @Autowired
    private TraceabilityRepository traceabilityRepository;

    @Override
    public void execute(Traceability traceability) {
        traceabilityRepository.save(traceability);
    }
}
