package com.metrodata.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.metrodata.entities.enums.SponsorCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @Column(nullable = false)
    private SponsorCategory category;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @JsonManagedReference
    @OneToMany(mappedBy = "sponsor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Speaker> speakerList;

}
