package com.metrodata.repositories;

import com.metrodata.entities.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
    // Method Query
    Speaker findSpeakerById(Long id);

    // JPQL
    @Query("SELECT s FROM Speaker s WHERE s.id = ?1")
    Speaker getSpeakerById(Long id);

    // SQL
    @Query(value = "SELECT * FROM tb_m_speakers WHERE id = ?1", nativeQuery = true)
    Speaker getSpeakerByIdNative(Long id);
}
