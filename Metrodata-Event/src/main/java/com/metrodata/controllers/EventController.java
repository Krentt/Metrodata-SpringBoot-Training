package com.metrodata.controllers;

import com.metrodata.entities.Event;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("event")
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseData<List<Event>> getEvents(){
        return eventService.getAllEvent();
    }

    @GetMapping("id")
    public Event getEventById(@PathVariable Long id){
        return eventService.getEventById(id);
    }

    @PostMapping
    public ResponseData<Event> insertEvent(@RequestBody Event event){
        return eventService.insertEvent(event);
    }

    @PatchMapping("{id}")
    public ResponseData<Event> updateEvent(@PathVariable long id, @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    @DeleteMapping("{id}")
    public ResponseData<Event> deleteEvent(@PathVariable long id) {
        return eventService.deleteEvent(id);
    }
}
