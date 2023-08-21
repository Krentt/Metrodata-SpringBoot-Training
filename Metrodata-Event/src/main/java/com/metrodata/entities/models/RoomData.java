package com.metrodata.entities.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomData {
    private String name;
    private Long eventId;
}
