package com.hotels.mart.application.strategies;
import com.hotels.mart.domain.entities.Traceability;

public interface TraceabilityStrategy {
    void execute(Traceability traceability);
}
