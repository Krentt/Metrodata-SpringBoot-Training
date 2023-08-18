package com.metrodata.repositories;

import com.metrodata.entities.Participant;
import jakarta.servlet.http.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    // Method Query
    List<Participant> findAllByUniversityIs(String university);

    // JPQL
    @Query("SELECT p FROM Participant p WHERE p.university = ?1")
    List<Participant> getAllByUniversity(String university);

    // SQL
    @Query(value = "SELECT * FROM tb_m_participants WHERE university = ?1", nativeQuery = true)
    List<Participant> getAllByUniversityNative(String university);
}
