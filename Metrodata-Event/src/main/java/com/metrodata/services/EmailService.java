package com.metrodata.services;

import com.metrodata.entities.models.EmailData;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

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

    public EmailData sendMailWithHTML(Context context, EmailData emailData){
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            String body = templateEngine.process("email-sender", context);

            helper.setFrom("thebesestgt@gmail.com");
            helper.setTo(emailData.getTo());
            helper.setSubject(emailData.getSubject());
            helper.setText(body, true);

            mailSender.send(message);
            System.out.println("Mail send...");
            return emailData;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public EmailData sendMailHTML(EmailData emailData){
        Context context = new Context();
        context.setVariable("to", emailData.getTo());
        context.setVariable("subject",  emailData.getSubject());
        context.setVariable("body", emailData.getBody());

        sendMailWithHTML(context, emailData);
        return emailData;
    }
}
