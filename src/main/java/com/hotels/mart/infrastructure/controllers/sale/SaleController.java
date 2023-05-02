package com.hotels.mart.infrastructure.controllers.sale;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotels.mart.application.dto.ResponseFormat;
import com.hotels.mart.application.services.sales.CreateSaleService;
import com.hotels.mart.application.services.sales.GetSaleByIdService;
import com.hotels.mart.domain.entities.Sale;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/sales")
@Slf4j
public class SaleController {

  @Autowired
  private GetSaleByIdService getSaleByIdService;

  @Autowired
  private CreateSaleService createSaleService;

  @GetMapping("/searchById")
  public ResponseEntity<?> serchById(@RequestParam(value = "sales_id", required = false) Long saleId) {
    log.info("Buscando Sale By Id");

    if (saleId == null) {
      ResponseFormat responseFormat = new ResponseFormat("El id de la Venta es requerido",
          HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());

      return ResponseEntity.badRequest().body(responseFormat);
    }

    var sale = getSaleByIdService.getSaleById(saleId);

    if (sale.isEmpty()) {
      ResponseFormat responseFormat = new ResponseFormat("No se encontro la habitacion con el id: " + saleId,
          HttpStatus.NOT_FOUND.value(), LocalDateTime.now());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseFormat);
    }

    // Si todo sale bien, se retorna el objeto
    return ResponseEntity.ok(sale);
  }

  @PostMapping()
  public ResponseEntity<?> createSale(@RequestBody Sale salesDto) {

    log.info("Creating Sale: {}", salesDto);

    ResponseFormat sale = createSaleService.createSale(salesDto);

    return new ResponseEntity<>(sale, HttpStatus.CREATED);
  }

}
