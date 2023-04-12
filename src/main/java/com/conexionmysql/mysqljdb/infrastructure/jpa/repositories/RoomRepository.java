package com.conexionmysql.mysqljdb.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conexionmysql.mysqljdb.infrastructure.jpa.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}