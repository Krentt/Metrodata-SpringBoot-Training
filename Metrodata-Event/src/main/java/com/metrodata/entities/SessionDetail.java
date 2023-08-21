package com.metrodata.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @JsonManagedReference
    @OneToOne(mappedBy = "sessionDetail", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Certificate certificate;

    @OneToMany(mappedBy = "sessionDetail", fetch = FetchType.EAGER)
    private List<SessionDetailRoom> sessionDetailRoomList;

    @OneToMany(mappedBy = "sessionDetail", fetch = FetchType.EAGER)
    private List<SessionSpeaker> sessionSpeakerList;

    @OneToMany(mappedBy = "sessionDetail", fetch = FetchType.EAGER)
    private List<SessionRegistrant> sessionRegistrantList;
}
