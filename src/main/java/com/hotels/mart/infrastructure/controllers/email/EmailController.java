package com.hotels.mart.infrastructure.controllers.email;

// import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.hotels.mart.application.dto.ResponseFormat;
import com.hotels.mart.application.services.emails.EmailService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/email")
@Slf4j
public class EmailController {
  @Autowired
  EmailService emailService;
  @Operation(summary = "Envio de correo", description = "Aquie podemos enviar correo mediante gmail", responses = {
    @ApiResponse(responseCode = "200", description = "Successful operation")
    })
  @GetMapping("/sendEmail")
  public ResponseEntity<?> sendEmail() {

    log.info("Sending reservation");

    var response = emailService.sendEmail("andresolano34@gmail.com",
        "titoantifa69@gmail.com", "Testing", "Hola Marte we are live");
    // return new ResponseEntity<>("Email sending", HttpStatus.CREATED);

    // ResponseFormat responseFormat = new ResponseFormat(
    //     "Email sending",
    //     HttpStatus.ACCEPTED.value(),
    //     LocalDateTime.now());

    return new ResponseEntity<>(response, HttpStatus.CREATED);

  }

}
