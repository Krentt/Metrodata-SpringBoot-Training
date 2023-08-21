package com.metrodata.controllers;

import com.metrodata.entities.Session;
import com.metrodata.entities.SessionDetail;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.entities.models.SessionData;
import com.metrodata.entities.models.SessionDetailData;
import com.metrodata.services.SessionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("session-detail")
public class SessionDetailController {
    private SessionDetailService sessionDetailService;

    @Autowired
    public SessionDetailController(SessionDetailService sessionDetailService){
        this.sessionDetailService = sessionDetailService;
    }

    @PostMapping
    public ResponseData<SessionDetail> insertSessionDetail(@RequestBody SessionDetailData sessionDetailData) {
        return sessionDetailService.insertSessionDetail(sessionDetailData);
    }

    @GetMapping
    public List<SessionDetail> getAllSessionDetail(){
        return sessionDetailService.getAllSessionDetail();
    }

    @GetMapping("{id}")
    public SessionDetail getSessionDetailById(@PathVariable Long id){
        return sessionDetailService.getSessionDetailById(id);
    }

    @PatchMapping("{id}")
    public ResponseData<SessionDetail> updateSessionDetail(@PathVariable Long id, @RequestBody SessionDetailData sessionDetailData){
        return sessionDetailService.updateSessionDetail(id, sessionDetailData);
    }

    @DeleteMapping("{id}")
    public SessionDetail deleteSessionDetail(@PathVariable Long id) {
        return sessionDetailService.deleteSessionDetail(id);
    }
}
