package com.metrodata.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "tb_m_events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column(length = 50, nullable = false)
    private String slug;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String location;

    @Column(name = "start_registration", nullable = false)
    private LocalDateTime startRegistration;

    @Column(name = "close_registration", nullable = false)
    private LocalDateTime closeRegistration;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String imageUrl;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Integer status;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Sponsor> sponsorList;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Participants> listParticipants;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Sessions> listSessions;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Rooms> roomsList;

}
