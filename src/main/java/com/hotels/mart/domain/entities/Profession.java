package com.hotels.mart.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Profession")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Profession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profession_id")
    private Integer profession_id;

    @Column(name = "name_profession", length = 255)
    private String name_profession;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "created_at")
    private LocalDateTime created_at;
}
