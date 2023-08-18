package com.metrodata.repositories;

import com.metrodata.entities.SessionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionDetailRepository extends JpaRepository<SessionDetail, Long> {
    // Method Query
    List<SessionDetail> findAllByCapacityGreaterThan(Integer size);

    // JPQL
    @Query("SELECT s FROM SessionDetail s WHERE s.capacity > ?1")
    List<SessionDetail> getAllByCapacityGreaterThan(Integer size);

    // SQL
    @Query(value = "SELECT * FROM tb_m_session_details WHERE capacity > ?1", nativeQuery = true)
    List<SessionDetail> getAllByCapacityGreaterThanNative(Integer size);
}
