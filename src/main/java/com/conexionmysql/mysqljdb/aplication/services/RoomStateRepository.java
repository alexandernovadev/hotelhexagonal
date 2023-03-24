package com.conexionmysql.mysqljdb.aplication.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.conexionmysql.mysqljdb.domain.models.RoomState;

@Repository
public interface RoomStateRepository extends JpaRepository<RoomState, Long> {

}