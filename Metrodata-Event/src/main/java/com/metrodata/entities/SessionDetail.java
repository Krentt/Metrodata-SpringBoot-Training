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
public class SessionDetail {
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
    private Session session;

    @OneToOne(mappedBy = "sessionDetail", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Certificate certificate;

    @OneToMany(mappedBy = "sessionDetail", cascade = CascadeType.ALL)
    private List<SessionDetailRoom> sessionDetailRoomList;

    @OneToMany(mappedBy = "sessionDetail", cascade = CascadeType.ALL)
    private List<SessionSpeaker> sessionSpeakerList;

    @OneToMany(mappedBy = "sessionDetail", cascade = CascadeType.ALL)
    private List<SessionRegistrant> sessionRegistrantList;
}
