package com.metrodata.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_m_speakers")
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String photo_url;

    @Column(length = 50, nullable = false)
    private String jobTitle;

    @Column(length = 100, nullable = false)
    private String company;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "sponsor")
    private Sponsor sponsor;

    @OneToMany(mappedBy = "speaker")
    private List<SessionSpeaker> sessionSpeakerList;
}
