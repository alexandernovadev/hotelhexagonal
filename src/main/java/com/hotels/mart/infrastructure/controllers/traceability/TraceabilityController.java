package com.hotels.mart.infrastructure.controllers.traceability;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotels.mart.application.dto.ResponseFormat;
import com.hotels.mart.application.services.traceability.GotraceabilityService;
// import com.hotels.mart.application.strategies.PrintPdfStrategy;
import com.hotels.mart.application.strategies.SaveToDatabaseStrategy;
import com.hotels.mart.domain.entities.Traceability;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/traceability")
@Slf4j
public class TraceabilityController {

  @Autowired
  private GotraceabilityService gotraceabilityService;

  @Autowired
  private SaveToDatabaseStrategy saveToDatabaseStrategy;

  // @Autowired
  // private PrintPdfStrategy printPdfStrategy;

  @PostMapping
  public ResponseEntity<?> saveTrazaliobite(@RequestBody Traceability traceabilitydto) {

    log.info("Save GotraceabilityService");
    
    // Selecciona la estrategia adecuada según las necesidades del negocio
    gotraceabilityService.setTraceabilityStrategy(saveToDatabaseStrategy);
    // O usa la siguiente línea en lugar de la anterior para cambiar a

    // PrintPdfStrategy
    // gotraceabilityService.setTraceabilityStrategy(printPdfStrategy);

    gotraceabilityService.saveAuditory(traceabilitydto);

    ResponseFormat response = new ResponseFormat();
    response.setMessage("Traceability successfully");
    response.setStatus(HttpStatus.CREATED.value());
    response.setTimestamp(LocalDateTime.now());

    return new ResponseEntity<>(response, HttpStatus.CREATED);

  }

}
