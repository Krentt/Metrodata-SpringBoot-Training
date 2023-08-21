package com.metrodata.services;

import com.metrodata.entities.Certificate;
import com.metrodata.entities.Event;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.repositories.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CertificateService {

    private CertificateRepository certificateRepository;

    @Autowired
    public CertificateService(CertificateRepository certificateRepository){
        this.certificateRepository = certificateRepository;
    }

    public ResponseData<List<Certificate>> getAllCertificates(){
        try {
            return new ResponseData<>(certificateRepository.findAll(), "Fetch all certificates success!");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public Certificate getCertificateById(Long id){
        return certificateRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Certificate not found"));
    }

    public ResponseData<Certificate> insertCertificate(Certificate certificate) {
        try {
            return new ResponseData<>(certificateRepository.save(certificate), "Certificate successfully created");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}
