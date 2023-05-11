package com.hotels.mart.application.strategies;

import org.springframework.stereotype.Component;

import com.hotels.mart.domain.entities.Traceability;

@Component
public class PrintPdfStrategy implements TraceabilityStrategy {

    @Override
    public void execute(Traceability traceability) {
        // Implementa la lógica para generar y guardar el PDF
    }
}
