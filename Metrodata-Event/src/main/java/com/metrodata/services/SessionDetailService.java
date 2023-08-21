package com.metrodata.services;

import com.metrodata.entities.Certificate;
import com.metrodata.entities.SessionDetail;
import com.metrodata.entities.Speaker;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.entities.models.SessionData;
import com.metrodata.entities.models.SessionDetailData;
import com.metrodata.entities.models.SpeakerData;
import com.metrodata.repositories.CertificateRepository;
import com.metrodata.repositories.SessionDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SessionDetailService {
    private SessionDetailRepository sessionDetailRepository;
    private SessionService sessionService;
    private CertificateRepository certificateRepository;

    @Autowired
    public SessionDetailService(SessionDetailRepository sessionDetailRepository, SessionService sessionService, CertificateRepository certificateRepository){
        this.sessionDetailRepository = sessionDetailRepository;
        this.sessionService = sessionService;
        this.certificateRepository = certificateRepository;
    }

    public List<SessionDetail> getAllSessionDetail() {
        return sessionDetailRepository.findAll();
    }

    public SessionDetail getSessionDetailById(Long id) {
        return sessionDetailRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sponsor with ID: " + id + " not found"));
    }

    public ResponseData<SessionDetail> insertSessionDetail(SessionDetailData sessionDetailData) {
        try {
            SessionDetail sessionDetail = new SessionDetail();
            sessionDetail.setName(sessionDetailData.getName());
            sessionDetail.setCapacity(sessionDetailData.getCapacity());
            sessionDetail.setDescription(sessionDetailData.getDescription());
            sessionDetail.setSession(sessionService.getSessionById(sessionDetailData.getSessionId()));

            Certificate certificate = new Certificate();
            certificate.setCertificateUrl(sessionDetailData.getCertificateUrl());
            certificate.setSessionDetail(sessionDetail);
            certificateRepository.save(certificate);

            sessionDetail.setCertificate(certificate);

            return new ResponseData<>(sessionDetailRepository.save(sessionDetail), "Session Detail successfully created");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public ResponseData<SessionDetail> updateSessionDetail(Long id, SessionDetailData sessionDetailData){
        try {
            SessionDetail sessionDetail = getSessionDetailById(id);
            sessionDetail.setName(sessionDetailData.getName());
            sessionDetail.setCapacity(sessionDetailData.getCapacity());
            sessionDetail.setDescription(sessionDetail.getDescription());
            sessionDetail.setSession(sessionService.getSessionById(sessionDetailData.getSessionId()));

            Certificate certificate = certificateRepository.getReferenceById(id);
            certificate.setCertificateUrl(sessionDetailData.getCertificateUrl());
            certificateRepository.save(certificate);

            return new ResponseData<>(sessionDetailRepository.save(sessionDetail), "Session Detail successfully updated");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public SessionDetail deleteSessionDetail(Long id){
        SessionDetail sessionDetail = getSessionDetailById(id);
        sessionDetailRepository.delete(sessionDetail);
        return sessionDetail;
    }
}
