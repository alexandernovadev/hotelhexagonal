package com.conexionmysql.mysqljdb.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "$NAMETABLE$")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class $NAMETABLEF$ {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long  $NAMETABLE$_id; 

  //...
  private String state;
}
