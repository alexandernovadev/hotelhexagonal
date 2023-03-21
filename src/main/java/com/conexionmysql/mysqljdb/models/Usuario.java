package com.conexionmysql.mysqljdb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Getter
   @Setter
   private Long id;

   @Getter
   @Setter
   private String surname;

   @Getter
   @Setter
   @NotBlank(message = "Name is required")
   @Size(max = 50, message = "Name must be less than 50 characters")
   private String name;

   @Getter
   @Setter
   @NotBlank(message = "Email is required")
   @Email(message = "Email must be a valid email address")
   private String email;

   @Getter
   @Setter
   private String phone;

   @Getter
   @Setter
   private String city;
   
   @Getter
   @Setter
   private String password;
}