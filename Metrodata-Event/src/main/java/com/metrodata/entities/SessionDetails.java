package com.metrodata.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tb_m_session_details")
public class SessionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer capacity;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Sessions sessions;

    @OneToOne(mappedBy = "sessionDetails", cascade = CascadeType.ALL)
    private Certifications certifications;

    @OneToMany(mappedBy = "sessionDetails")
    private List<SessionDetailRooms> sessionDetailRoomsList;
}
