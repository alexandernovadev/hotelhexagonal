package com.hotels.mart.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

   @OneToOne
   @JoinColumn(name = "user_state_id")
   private UserState user_state_id;

   private String name;
   private String email;
   private String password;

   @Column(name = "age")
   private Integer age;

   @ManyToOne
   @JoinColumn(name = "sex_id")
   private Sex sex;

   @ManyToOne
   @JoinColumn(name = "profession_id")
   private Profession profession;

   @ManyToOne
   @JoinColumn(name = "city_id")
   private City city;

   @Column(name = "created_at")
   private LocalDateTime created_at;

}