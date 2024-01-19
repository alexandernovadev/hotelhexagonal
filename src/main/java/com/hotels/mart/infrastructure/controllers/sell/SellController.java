package com.hotels.mart.infrastructure.controllers.sell;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotels.mart.application.dto.PurshaseDto;
import com.hotels.mart.application.services.sell.CreateSellService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/sells")
@Slf4j
public class SellController {

  @Autowired
  private CreateSellService createSellService;

  @PostMapping("do-purshase")
  public ResponseEntity<?> doPpurshase(@RequestBody PurshaseDto purshaseDto) {
    // public ResponseEntity<?> doPpurshase() {

    var response = createSellService.createSell(purshaseDto);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
