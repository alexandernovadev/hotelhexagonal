package com.conexionmysql.mysqljdb.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conexionmysql.mysqljdb.infrastructure.jpa.entities.RoomType;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

}