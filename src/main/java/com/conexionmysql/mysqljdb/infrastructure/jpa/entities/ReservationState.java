package com.conexionmysql.mysqljdb.infrastructure.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "reservations_state")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ReservationState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_state_id")
    private Long id;

    @Column(name = "state")
    private String state;

}
