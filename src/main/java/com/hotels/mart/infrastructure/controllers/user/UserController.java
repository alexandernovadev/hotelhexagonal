package com.hotels.mart.infrastructure.controllers.user;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotels.mart.application.dto.ResponseFormat;
import com.hotels.mart.application.services.user.CreateUserService;
import com.hotels.mart.application.services.user.DeleteUserService;
import com.hotels.mart.application.services.user.GetAllUserService;
import com.hotels.mart.application.services.user.GetUserByIdService;
import com.hotels.mart.application.services.user.UpdateUserService;
import com.hotels.mart.domain.entities.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

   @Autowired
   private CreateUserService createUserService;
   @Autowired
   private GetAllUserService getAllUserService;
   @Autowired
   private UpdateUserService updateUserService;
   @Autowired
   private DeleteUserService deleteUserService;

   @Autowired
   private GetUserByIdService getUserByIdService;

   @Operation(summary = "Get a user by id", description = "Return a user", responses = {
         @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = User.class))),
         @ApiResponse(responseCode = "400", description = "Invalid id supplied"),
         @ApiResponse(responseCode = "404", description = "User not found") })
   @GetMapping("/{id}")
   public ResponseEntity<?> getUserById(@PathVariable Long id) {
      log.info("Getting user with ID: {}", id);
      return new ResponseEntity<>(getUserByIdService.getUserById(id), HttpStatus.OK);
   }

   @Operation(summary = "Get a All Users", description = "Return a list of users", responses = {
         @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = User.class))),
         @ApiResponse(responseCode = "400", description = "Invalid id supplied"),
         @ApiResponse(responseCode = "404", description = "User not found") })
   @GetMapping
   public ResponseEntity<?> getUsers() {
      log.info("Getting users");
      return new ResponseEntity<>(getAllUserService.getAllUsers(), HttpStatus.OK);
   }

   @Operation(summary = "Create a new User", description = "Creates a new user and returns it", responses = {
         @ApiResponse(responseCode = "201", description = "User created successfully"),
         @ApiResponse(responseCode = "400", description = "Invalid input"),
         @ApiResponse(responseCode = "409", description = "User already exists") })
   @PostMapping
   public ResponseEntity<?> createUser(@RequestBody User userDto) {
      log.info("Creating user: {}", userDto);

      createUserService.createUser(userDto);

      ResponseFormat response = new ResponseFormat();
      response.setMessage("User created successfully");
      response.setStatus(HttpStatus.CREATED.value());
      response.setTimestamp(LocalDateTime.now());

      return new ResponseEntity<>(response, HttpStatus.CREATED);
   }

   @Operation(summary = "Update a User", description = "Updates an existing user and returns it", responses = {
         @ApiResponse(responseCode = "200", description = "User updated successfully"),
         @ApiResponse(responseCode = "400", description = "Invalid input"),
         @ApiResponse(responseCode = "404", description = "User not found") })
   @PutMapping
   public ResponseEntity<?> updateUser(@RequestBody User userDto) {
      log.info("Updating user: {}", userDto);
      updateUserService.updateUser(userDto);

      ResponseFormat response = new ResponseFormat();
      response.setMessage("User Updated successfully");
      response.setStatus(HttpStatus.CREATED.value());
      response.setTimestamp(LocalDateTime.now());

      return new ResponseEntity<>(response, HttpStatus.CREATED);

   }

   @Operation(summary = "Delete a User by id", description = "Deletes an existing user and returns a confirmation", responses = {
         @ApiResponse(responseCode = "204", description = "User deleted successfully"),
         @ApiResponse(responseCode = "400", description = "Invalid input"),
         @ApiResponse(responseCode = "404", description = "User not found") })
   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteUser(@PathVariable Long id) {
      log.info("Deleting user with ID: {}", id);
      deleteUserService.deleteUser(id);

      ResponseFormat response = new ResponseFormat();
      response.setMessage("User Deleted successfully");
      response.setStatus(HttpStatus.CREATED.value());
      response.setTimestamp(LocalDateTime.now());

      return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);

   }

}
