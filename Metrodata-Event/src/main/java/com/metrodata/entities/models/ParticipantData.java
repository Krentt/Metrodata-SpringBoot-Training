package com.metrodata.entities.models;

import com.metrodata.entities.enums.Occupation;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParticipantData {
    private String name;
    private String email;
    private String university;
    private String phoneNumber;
    private String address;

    @Enumerated(EnumType.STRING)
    private Occupation occupation;

    private Long eventId;
}
