package com.metrodata.services;

import com.metrodata.entities.models.EmailData;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailData sendEmail(EmailData emailData){
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom("thebesestgt@gmail.com");
            message.setTo(emailData.getTo());
            message.setSubject(emailData.getSubject());
            message.setText(emailData.getBody());

            mailSender.send(message);
            System.out.println("Mail send...");
            return emailData;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
