package com.metrodata.controllers;

import com.metrodata.entities.Participant;
import com.metrodata.entities.Session;
import com.metrodata.entities.models.ParticipantData;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.entities.models.SessionData;
import com.metrodata.services.ParticipantService;
import com.metrodata.services.SessionService;
import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("participant")
public class ParticipantController {
    private ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping
    public ResponseData<Participant> insertParticipant(@RequestBody ParticipantData participantData) {
        return participantService.insertParticipant(participantData);
    }

    @GetMapping
    public List<Participant> getAllParticipant(){
        return participantService.getAllParticipant();
    }

    @GetMapping("{id}")
    public Participant getParticipantById(@PathVariable Long id){
        return participantService.getParticipantById(id);
    }

    @PatchMapping("{id}")
    public ResponseData<Participant> updateParticipant(@PathVariable Long id, @RequestBody ParticipantData participantData){
        return participantService.updateParticipant(id, participantData);
    }

    @DeleteMapping("{id}")
    public Participant deleteParticipant(@PathVariable Long id) {
        return participantService.deleteParticipant(id);
    }
}
