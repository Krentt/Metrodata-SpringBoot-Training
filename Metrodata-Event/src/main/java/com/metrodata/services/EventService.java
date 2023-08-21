package com.metrodata.services;

import com.metrodata.entities.Event;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EventService {
    private EventRepository eventRepository;

    @Autowired
    public void EventRepository(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    public ResponseData<List<Event>> getAllEvent(){
        try {
            return new ResponseData<>(eventRepository.findAll(), "Fetch all events success!");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public Event getEventById(Long id){
        return eventRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
    }

    public ResponseData<Event> insertEvent(Event event) {
        try {
            return new ResponseData<>(eventRepository.save(event), "Event successfully created");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public ResponseData<Event> updateEvent(long id, Event eventData){
        try{
            Event event = getEventById(id);
            event.setName(eventData.getName());
            event.setSlug(eventData.getSlug());
            event.setStartRegistration(eventData.getStartRegistration());
            event.setCloseRegistration(eventData.getCloseRegistration());
            event.setEndDate(eventData.getEndDate());
            event.setStartDate(eventData.getStartDate());
            event.setStartTime(eventData.getStartTime());
            event.setCapacity(eventData.getCapacity());
            event.setDescription(eventData.getDescription());
            event.setLocation(eventData.getLocation());
            event.setImageUrl(event.getImageUrl());
            event.setStatus(event.getStatus());
            return new ResponseData<>(eventRepository.save(event), "Event succesfully updated!");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public ResponseData<Event> deleteEvent(Long id) {
        try{
            Event event = getEventById(id);
            eventRepository.delete(event);
            return new ResponseData<>(null, "Event with id " + id + " succesfully deleted");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}
