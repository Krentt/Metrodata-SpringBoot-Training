package com.metrodata.controllers;

import com.metrodata.entities.Participant;
import com.metrodata.entities.Room;
import com.metrodata.entities.models.ParticipantData;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.entities.models.RoomData;
import com.metrodata.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("room")
public class RoomController {
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseData<Room> insertRoom(@RequestBody RoomData roomData) {
        return roomService.insertRoom(roomData);
    }

    @GetMapping
    public List<Room> getAllRooms(){
        return roomService.getAllRoom();
    }

    @GetMapping("{id}")
    public Room getRoomById(@PathVariable Long id){
        return roomService.getRoomById(id);
    }

    @PatchMapping("{id}")
    public ResponseData<Room> updateRoom(@PathVariable Long id, @RequestBody RoomData roomData){
        return roomService.updateRoom(id, roomData);
    }

    @DeleteMapping("{id}")
    public Room deleteRoom(@PathVariable Long id) {
        return roomService.deleteRoom(id);
    }
}
