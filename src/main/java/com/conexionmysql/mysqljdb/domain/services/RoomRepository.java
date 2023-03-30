package com.conexionmysql.mysqljdb.domain.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.conexionmysql.mysqljdb.domain.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}