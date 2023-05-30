package com.hotels.mart.infrastructure.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import com.hotels.mart.application.dto.JWTResponseApiDto;
import com.hotels.mart.application.dto.LoginUserDto;
import com.hotels.mart.application.dto.ResponseApi;
import com.hotels.mart.application.dto.UserRegisterDto;
import com.hotels.mart.application.services.auth.LoginUserService;
import com.hotels.mart.application.services.auth.RegisterUserService;

import lombok.extern.slf4j.Slf4j;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

  @Autowired
  RegisterUserService serviceRegister;

  @Autowired
  LoginUserService loginUserService;

  @Operation(summary = "User login", description = "Authenticate a user with email and password and return a JWT token if successful", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "User login credentials", required = true, content = @Content(schema = @Schema(implementation = LoginUserDto.class))), responses = {
      @ApiResponse(responseCode = "201", description = "Login successful", content = @Content(schema = @Schema(implementation = JWTResponseApiDto.class))),
      @ApiResponse(responseCode = "401", description = "Unauthorized - Invalid password"),
      @ApiResponse(responseCode = "404", description = "Not Found - User does not exist"),
      @ApiResponse(responseCode = "418", description = "I'm a teapot - Fields not valid")
  })
  @PostMapping("/login")
  public ResponseEntity<?> loginUser(@RequestBody LoginUserDto loginUserDto) {

    log.info("Login with JWT");

    var response = loginUserService.doLogin(loginUserDto);

    JWTResponseApiDto responseJWT = new JWTResponseApiDto();

    if (response.getStatus() == HttpStatus.CREATED) {
      responseJWT.setMessage("token");
      responseJWT.setToken(response.getData().get(0).toString());
    } else {
      responseJWT.setMessage("User No valid");
      responseJWT.setToken("---");
    }

    return new ResponseEntity<>(responseJWT, response.getStatus());

  }

  @Operation(summary = "User registration", description = "Register a new user with email, name, and password. Returns a confirmation message if successful", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "User registration data", required = true, content = @Content(schema = @Schema(implementation = UserRegisterDto.class))), responses = {
      @ApiResponse(responseCode = "201", description = "User created successfully", content = @Content(schema = @Schema(implementation = ResponseApi.class))),
      @ApiResponse(responseCode = "400", description = "Bad Request - Invalid input data, such as incorrect email format, password length not between 5 and 20 characters, or name length not between 4 and 80 characters"),
  })
  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@RequestBody UserRegisterDto userRegisterDto) {

    log.info("Register with JWT");

    var response = serviceRegister.createUser(userRegisterDto);

    return new ResponseEntity<>(response, response.getStatus());

  }
}
