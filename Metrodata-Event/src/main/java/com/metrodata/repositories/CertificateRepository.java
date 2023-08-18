package com.metrodata.repositories;

import com.metrodata.entities.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    // Query Method
    Certificate findCertificationsByCertificateUrl(String certificateUrl);

    // JPQL
    @Query("SELECT p FROM Certificate p WHERE p.certificateUrl = ?1")
    Certificate getCertificationsByCertificateUrl(String certificateUrl);

    // SQL
    @Query(value = "SELECT * FROM tb_m_certificate_templates WHERE certificate_url= ?1", nativeQuery = true)
    Certificate getCertificationsByCertificateUrlNative(String certificateUrl);
}
