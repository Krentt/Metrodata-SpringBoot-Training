package com.metrodata.services;

import com.metrodata.entities.Speaker;
import com.metrodata.entities.Sponsor;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.entities.models.SpeakerData;
import com.metrodata.entities.models.SponsorData;
import com.metrodata.repositories.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SpeakerService {
    private SpeakerRepository speakerRepository;
    private SponsorService sponsorService;

    @Autowired
    public SpeakerService(SpeakerRepository speakerRepository, SponsorService sponsorService){
        this.speakerRepository = speakerRepository;
        this.sponsorService = sponsorService;
    }

    public List<Speaker> getAllSpeaker() {
        return speakerRepository.findAll();
    }

    public Speaker getSpeakerById(Long id) {
        return speakerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sponsor with ID: " + id + " not found"));
    }

    public ResponseData<Speaker> insertSpeaker(SpeakerData speakerData) {
        try {
            Speaker speaker = new Speaker();
            speaker.setName(speakerData.getName());
            speaker.setPhoto_url(speakerData.getPhotoUrl());
            speaker.setJobTitle(speakerData.getJobTitle());
            speaker.setCompany(speakerData.getCompany());
            speaker.setSponsor(sponsorService.getSponsorById(speakerData.getSponsorId()));
            return new ResponseData<>(speakerRepository.save(speaker), "Speaker successfully created");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public ResponseData<Speaker> updateSpeaker(Long id, SpeakerData speakerData){
        try {
            Speaker speaker = getSpeakerById(id);
            speaker.setName(speakerData.getName());
            speaker.setPhoto_url(speakerData.getPhotoUrl());
            speaker.setJobTitle(speakerData.getJobTitle());
            speaker.setCompany(speakerData.getCompany());
            speaker.setSponsor(sponsorService.getSponsorById(speakerData.getSponsorId()));
            return new ResponseData<>(speakerRepository.save(speaker), "Speaker successfully updated");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public Speaker deleteSpeaker(Long id){
        Speaker speaker = getSpeakerById(id);
        speakerRepository.delete(speaker);
        return speaker;
    }
}
