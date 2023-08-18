package com.metrodata.entities;

import com.metrodata.entities.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_tr_session_registrants")
public class SessionRegistrants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "attended_at")
    private LocalDateTime attendedAt;

    @Column(name = "is_attended", columnDefinition = "TINYINT")
    private Integer isAttended;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "registered_at", nullable = false)
    private LocalDateTime registeredAt;

    @Column(name = "is_reminder_sent", columnDefinition = "TINYINT", nullable = false)
    private Integer isReminderSent;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participants participant;

    @ManyToOne
    @JoinColumn(name = "session_detail_id")
    private SessionDetails sessionDetail;


}
