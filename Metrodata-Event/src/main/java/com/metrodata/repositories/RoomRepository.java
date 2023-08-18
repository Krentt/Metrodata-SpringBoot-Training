package com.metrodata.repositories;

import com.metrodata.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    // Method Query
    Room findRoomByIdIs(Long Id);

    // JPQL
    @Query("SELECT p FROM Room p WHERE p.id = ?1")
    Room getRoomById(Long id);

    // SQL
    @Query(value = "SELECT * FROM tb_m_rooms WHERE id = ?1", nativeQuery = true)
    Room getRoomByIdNative(Long id);
}
