package com.metrodata.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tb_m_certificate_templates")
public class Certificate {
    @Id
    private Long id;

    @Column(name = "certificate_url", columnDefinition = "TEXT", nullable = false)
    private String certificateUrl;

    @OneToOne
    @JsonBackReference
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    private SessionDetail sessionDetail;
}
