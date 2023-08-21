package com.metrodata.controllers;

import com.metrodata.entities.Event;
import com.metrodata.entities.Session;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.entities.models.SessionData;
import com.metrodata.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("session")
public class SessionController {

    private SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    public ResponseData<Session> insertSession(@RequestBody SessionData sessionData) {
        return sessionService.insertSession(sessionData);
    }

    @GetMapping
    public List<Session> getAllSession(){
        return sessionService.getSessions();
    }

    @GetMapping("{id}")
    public Session getSessionById(@PathVariable Long id){
        return sessionService.getSessionById(id);
    }

    @PatchMapping("{id}")
    public ResponseData<Session> updateSession(@PathVariable Long id, @RequestBody SessionData sessionData){
        return sessionService.updateSession(id, sessionData);
    }

    @DeleteMapping("{id}")
    public Session deleteEvent(@PathVariable Long id) {
        return sessionService.deleteSession(id);
    }
}
