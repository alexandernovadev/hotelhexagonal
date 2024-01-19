package com.hotels.mart.infrastructure.controllers.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/test")
@Slf4j
public class TestController {

  @GetMapping("/hello")
  public String hello() {
    log.info("Endpoint '/hello' fue llamado");
    return "Hello from TestController!";
  }
}
