package com.conexionmysql.mysqljdb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String surname;

   @NotBlank(message = "Name is required")
   @Size(max = 50, message = "Name must be less than 50 characters")
   private String name;

   @NotBlank(message = "Email is required")
   @Email(message = "Email must be a valid email address")
   private String email;

   private String phone;
   private String city;
   private String password;
}