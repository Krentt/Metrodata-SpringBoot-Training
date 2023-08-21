package com.metrodata.controllers;

import com.metrodata.entities.Speaker;
import com.metrodata.entities.Sponsor;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.entities.models.SpeakerData;
import com.metrodata.entities.models.SponsorData;
import com.metrodata.services.SpeakerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("speaker")
public class SpeakerController {
    private SpeakerService speakerService;

    public SpeakerController(SpeakerService speakerService){
        this.speakerService = speakerService;
    }

    @PostMapping
    public ResponseData<Speaker> insertSpeaker(@RequestBody SpeakerData speakerData) {
        return speakerService.insertSpeaker(speakerData);
    }

    @GetMapping
    public List<Speaker> getAllSpeakers(){
        return speakerService.getAllSpeaker();
    }

    @GetMapping("{id}")
    public Speaker getSpeakerById(@PathVariable Long id){
        return speakerService.getSpeakerById(id);
    }

    @PatchMapping("{id}")
    public ResponseData<Speaker> updateSpeaker(@PathVariable Long id, @RequestBody SpeakerData speakerData){
        return speakerService.updateSpeaker(id, speakerData);
    }

    @DeleteMapping("{id}")
    public Speaker deleteSpeaker(@PathVariable Long id) {
        return speakerService.deleteSpeaker(id);
    }
}
