package com.metrodata.repositories;

import com.metrodata.entities.SessionRegistrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRegistrantRepository extends JpaRepository<SessionRegistrant, Long> {
    // Method Query
    List<SessionRegistrant> findAllByIsReminderSentIs(Boolean status);

    // JPQL
    @Query("SELECT sr FROM SessionRegistrant sr WHERE sr.isReminderSent = ?1")
    List<SessionRegistrant> getAllByIsReminderSentIs(Boolean status);

    // SQL
    @Query(value = "SELECT * FROM tb_tr_session_registrants WHERE is_reminder_sent = ?1", nativeQuery = true)
    List<SessionRegistrant> getAllByIsReminderSentIsNative(Boolean status);
}
