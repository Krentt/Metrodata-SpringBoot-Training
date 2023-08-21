package com.metrodata.controllers;

import com.metrodata.entities.Certificate;
import com.metrodata.entities.Event;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("certificate")
public class CertificateController {
    private CertificateService certificateService;

    @Autowired
    public CertificateController (CertificateService certificateService){
        this.certificateService = certificateService;
    }

    @GetMapping
    public ResponseData<List<Certificate>> getAllCertificates(){
        return certificateService.getAllCertificates();
    }

    @GetMapping("id")
    public Certificate getCertificateById(@PathVariable Long id){
        return certificateService.getCertificateById(id);
    }

}
