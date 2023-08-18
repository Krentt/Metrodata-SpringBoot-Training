package com.metrodata.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_tr_session_speakers")
public class SessionSpeakers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "speaker_id")
    private Speakers speaker;

    @ManyToOne
    @JoinColumn(name = "session_detail_id")
    private SessionDetails sessionDetails;
}
