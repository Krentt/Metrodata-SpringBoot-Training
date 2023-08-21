package com.metrodata.controllers;

import com.metrodata.entities.Session;
import com.metrodata.entities.Sponsor;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.entities.models.SessionData;
import com.metrodata.entities.models.SponsorData;
import com.metrodata.services.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sponsor")
public class SponsorController {
    private SponsorService sponsorService;

    @Autowired
    public SponsorController(SponsorService sponsorService){
        this.sponsorService = sponsorService;
    }

    @PostMapping
    public ResponseData<Sponsor> insertSponsor(@RequestBody SponsorData sponsorData) {
        return sponsorService.insertSponsor(sponsorData);
    }

    @GetMapping
    public List<Sponsor> getAllSponsor(){
        return sponsorService.getAllSponsors();
    }

    @GetMapping("{id}")
    public Sponsor getSponsorById(@PathVariable Long id){
        return sponsorService.getSponsorById(id);
    }

    @PatchMapping("{id}")
    public ResponseData<Sponsor> updateSponsor(@PathVariable Long id, @RequestBody SponsorData sponsorData){
        return sponsorService.updateSponsor(id, sponsorData);
    }

    @DeleteMapping("{id}")
    public Sponsor deleteSponsor(@PathVariable Long id) {
        return sponsorService.deleteSponsor(id);
    }
}
