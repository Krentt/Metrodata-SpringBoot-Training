package com.metrodata.repositories;

import com.metrodata.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Method Query
    List<Event> findAllByCapacityGreaterThan(Integer size);

    // JPQL
    @Query("SELECT p FROM Event p WHERE p.capacity > ?1")
    List<Event> getAllByCapacityGreaterThan(Integer size);

    // SQL
    @Query(value = "SELECT * FROM tb_m_events WHERE capacity > ?1", nativeQuery = true)
    List<Event> getAllByCapacityGreaterThanNative(Integer size);
}
