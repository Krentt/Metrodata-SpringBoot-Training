package com.metrodata.entities.models;

import com.metrodata.entities.enums.SponsorCategory;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SponsorData {
    private String name;
    private String logoUrl;
    @Enumerated(EnumType.STRING)
    private SponsorCategory category;
    private Long eventId;
}
