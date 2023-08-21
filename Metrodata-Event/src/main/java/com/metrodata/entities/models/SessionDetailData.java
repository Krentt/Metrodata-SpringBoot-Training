package com.metrodata.entities.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SessionDetailData {
    private String name;
    private Integer capacity;
    private String description;
    private Long sessionId;
    private String certificateUrl;
}
