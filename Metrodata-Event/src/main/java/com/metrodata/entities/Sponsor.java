package com.metrodata.entities;

import com.metrodata.entities.enums.SponsorCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_m_sponsors")
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String logoUrl;

    @Enumerated(EnumType.STRING)
    private SponsorCategory category;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

}
