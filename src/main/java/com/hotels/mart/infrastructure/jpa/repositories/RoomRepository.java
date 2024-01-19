// package com.hotels.mart.infrastructure.jpa.repositories;

// import java.math.BigDecimal;
// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import com.hotels.mart.domain.entities.Room;


// public interface RoomRepository extends JpaRepository<Room, Long> {

//   // Set state_room_id to 1 for all rooms
//   @Modifying
//   @Query("UPDATE Room r SET r.state_room_id = (SELECT rs FROM RoomState rs WHERE rs.id = 1)")
//   void setAllRoomStateRoomIdToOne();

//   @Query("SELECT r FROM Room r " +
//       "WHERE (:roomId is null or r.room_id = :roomId) " +
//       "AND (:typeRoomId is null or r.type_room_id.id = :typeRoomId) " +
//       "AND (:stateRoomId is null or r.state_room_id.id = :stateRoomId) " +
//       "AND (:name is null or r.name = :name) " +
//       "AND (:description is null or r.description = :description) " +
//       "AND (:cost is null or r.cost = :cost)")
//   List<Room> findByCriteria(
//       @Param("roomId") Long roomId,
//       @Param("typeRoomId") Long typeRoomId,
//       @Param("stateRoomId") Long stateRoomId,
//       @Param("name") String name,
//       @Param("description") String description,
//       @Param("cost") BigDecimal cost);

// }