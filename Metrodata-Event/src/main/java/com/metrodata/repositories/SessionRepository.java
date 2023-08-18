package com.metrodata.repositories;

import com.metrodata.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    // Method Query
    List<Session> findAllByNameContaining(String name);

    // JPQL
    @Query("SELECT s FROM Session s WHERE s.name LIKE %?1%")
    List<Session> getAllByNameContaining(String name);

    // SQL
    @Query(value = "SELECT * FROM tb_m_sessions WHERE name LIKE %?1%", nativeQuery = true)
    List<Session> getAllByNameContainingNative(String name);
}
