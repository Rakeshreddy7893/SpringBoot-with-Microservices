package com.recykal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendEmail(String recipient,String body,String subject,String fromEmailId){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromEmailId);
        simpleMailMessage.setTo(recipient);
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(subject);

        javaMailSender.send(simpleMailMessage);

    }


}
