package com.metrodata.services;

import com.metrodata.entities.Participant;
import com.metrodata.entities.Room;
import com.metrodata.entities.models.ParticipantData;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.entities.models.RoomData;
import com.metrodata.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RoomService {
    private RoomRepository roomRepository;
    private EventService eventService;

    @Autowired
    public RoomService(RoomRepository roomRepository, EventService eventService){
        this.roomRepository = roomRepository;
        this.eventService = eventService;
    }

    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Session with ID: " + id + " not found"));
    }

    public ResponseData<Room> insertRoom(RoomData roomData) {
        try {
            Room room = new Room();
            room.setName(roomData.getName());
            room.setEvent(eventService.getEventById(roomData.getEventId()));
            return new ResponseData<>(roomRepository.save(room), "Room successfully created");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public ResponseData<Room> updateRoom(Long id, RoomData roomData){
        try {
            Room room = getRoomById(id);
            room.setName(roomData.getName());
            room.setEvent(eventService.getEventById(roomData.getEventId()));
            return new ResponseData<>(roomRepository.save(room), "Room successfully updated");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public Room deleteRoom(Long id){
        Room room = getRoomById(id);
        roomRepository.delete(room);
        return room;
    }
}
