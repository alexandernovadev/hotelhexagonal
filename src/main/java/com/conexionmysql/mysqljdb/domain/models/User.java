package com.conexionmysql.mysqljdb.domain.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long user_id;

   private String user_type;

   @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
   private Long user_state;
   private String name;
   private String email;
   private String password;
   private String state;

}