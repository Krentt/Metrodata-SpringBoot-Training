package com.metrodata.repositories;

import com.metrodata.entities.SessionDetailRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionDetailRoomRepository extends JpaRepository<SessionDetailRoom, Long> {
    // Method Query
    SessionDetailRoom findByIdIs(Long id);

    // JPQL
    @Query("SELECT s FROM SessionDetailRoom s WHERE s.id = ?1")
    SessionDetailRoom getSessionDetailRoomByById(Long id);

    // SQL
    @Query(value = "SELECT * FROM tb_tr_session_detail_rooms WHERE id = ?1", nativeQuery = true)
    SessionDetailRoom getSessionDetailRoomByByIdNative(Long id);
}
