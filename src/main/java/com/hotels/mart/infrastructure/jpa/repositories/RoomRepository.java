package com.hotels.mart.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotels.mart.domain.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

  // Set state_room_id to 1 for all rooms
  @Modifying
  @Query("UPDATE Room r SET r.state_room_id = (SELECT rs FROM RoomState rs WHERE rs.id = 1)")
  void setAllRoomStateRoomIdToOne();

}