package com.metrodata.repositories;

import com.metrodata.entities.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Long> {
    // Method Query
    List<Sponsor> findAllByNameContaining(String name);

    // JPQL
    @Query("SELECT s FROM Sponsor s WHERE s.name LIKE %?1%")
    List<Sponsor> getAllByNameContaining(String name);

    // SQL
    @Query(value = "SELECT * FROM tb_m_sponsors WHERE name LIKE %?1%", nativeQuery = true)
    List<Sponsor> getAllByNameContainingNative(String name);
}
