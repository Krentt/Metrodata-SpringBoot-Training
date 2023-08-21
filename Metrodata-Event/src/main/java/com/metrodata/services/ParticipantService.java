package com.metrodata.services;

import com.metrodata.entities.Participant;
import com.metrodata.entities.Session;
import com.metrodata.entities.models.ParticipantData;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.entities.models.SessionData;
import com.metrodata.repositories.ParticipantRepository;
import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ParticipantService {

    private ParticipantRepository participantRepository;
    private EventService eventService;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository, EventService eventService){
        this.participantRepository = participantRepository;
        this.eventService = eventService;
    }

    public List<Participant> getAllParticipant() {
        return participantRepository.findAll();
    }

    public Participant getParticipantById(Long id) {
        return participantRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Session with ID: " + id + " not found"));
    }

    public ResponseData<Participant> insertParticipant(ParticipantData participantData) {
        try {
            Participant participant = new Participant();
            participant.setName(participantData.getName());
            participant.setEmail(participantData.getEmail());
            participant.setUniversity(participantData.getUniversity());
            participant.setPhoneNumber(participantData.getPhoneNumber());
            participant.setAddress(participantData.getAddress());
            participant.setOccupation(participantData.getOccupation());
            participant.setEvent(eventService.getEventById(participantData.getEventId()));
            return new ResponseData<>(participantRepository.save(participant), "Participant successfully created");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public ResponseData<Participant> updateParticipant(Long id, ParticipantData participantData){
        try {
            Participant participant = getParticipantById(id);
            participant.setName(participantData.getName());
            participant.setEmail(participantData.getEmail());
            participant.setUniversity(participantData.getUniversity());
            participant.setPhoneNumber(participantData.getPhoneNumber());
            participant.setAddress(participantData.getAddress());
            participant.setOccupation(participantData.getOccupation());
            participant.setEvent(eventService.getEventById(participantData.getEventId()));
            return new ResponseData<>(participantRepository.save(participant), "Participant successfully updated");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public Participant deleteParticipant(Long id){
        Participant participant = getParticipantById(id);
        participantRepository.delete(participant);
        return participant;
    }


}
