package com.recykal.controller;

import com.recykal.dto.EmailRequest;
import com.recykal.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private SendEmailService service;

    @Value("$(spring.mail.username)")
    private  String fromEmailId;

    @PostMapping("/sendEmail")
    public String sendmail(@RequestBody EmailRequest emailRequest){
        service.sendEmail(emailRequest.getTo(),emailRequest.getBody(),emailRequest.getSubject(),fromEmailId);
        return "Sent Successfully";
    }
}
