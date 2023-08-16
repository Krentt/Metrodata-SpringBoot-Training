package com.metrodata.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 100, nullable = false)
    private String location;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Sponsor> sponsorList;

    @ManyToMany
    @JoinTable(
            name = "tb_tr_list_participants",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "participants_id")
    )
    private List<Participants> listParticipants;

}
