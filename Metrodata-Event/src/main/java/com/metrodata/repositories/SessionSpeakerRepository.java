package com.metrodata.repositories;

import com.metrodata.entities.SessionSpeaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionSpeakerRepository extends JpaRepository<SessionSpeaker, Long> {
    // Method Query
    SessionSpeaker findSessionSpeakerById(Long id);

    // JPQL
    @Query("SELECT ss FROM SessionSpeaker ss WHERE ss.id = ?1")
    SessionSpeaker getSessionSpeakerById(Long id);

    // SQL
    @Query(value = "SELECT * FROM tb_tr_session_speakers WHERE id = ?1", nativeQuery = true)
    SessionSpeaker getSessionSpeakerByIdNative(Long id);

}
