package com.metrodata.services;

import com.metrodata.entities.Event;
import com.metrodata.entities.Session;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.entities.models.SessionData;
import com.metrodata.repositories.EventRepository;
import com.metrodata.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SessionService {

    private SessionRepository sessionRepository;
    private EventService eventService;

    @Autowired
    public SessionService(SessionRepository sessionRepository, EventService eventService) {
        this.sessionRepository = sessionRepository;
        this.eventService = eventService;
    }

    public List<Session> getSessions() {
        return sessionRepository.findAll();
    }

    public Session getSessionById(Long id) {
        return sessionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Session with ID: " + id + " not found"));
    }

    public ResponseData<Session> insertSession(SessionData sessionData) {
        try {
            Session session = new Session();
            session.setName(sessionData.getName());
            session.setStartTime(sessionData.getStartTime());
            session.setEndTime(sessionData.getEndTime());
            session.setDescription(sessionData.getDescription());
            session.setNeedAttendance(sessionData.getNeedAttendance());
            session.setEvent(eventService.getEventById(sessionData.getEventId()));
            return new ResponseData<>(sessionRepository.save(session), "Session successfully created");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public ResponseData<Session> updateSession(Long id, SessionData sessionData){
        try {
            Session session = getSessionById(id);
            session.setName(sessionData.getName());
            session.setDescription(sessionData.getDescription());
            session.setStartTime(sessionData.getStartTime());
            session.setEndTime(sessionData.getEndTime());
            session.setNeedAttendance(sessionData.getNeedAttendance());
            session.setEvent(eventService.getEventById(sessionData.getEventId()));
            return new ResponseData<>(sessionRepository.save(session), "Session successfully updated");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public Session deleteSession(Long id){
        Session session = getSessionById(id);
        sessionRepository.delete(session);
        return session;
    }


}
