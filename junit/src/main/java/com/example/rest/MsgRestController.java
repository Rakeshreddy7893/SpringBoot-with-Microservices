package com.example.rest;

import com.example.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

    @Autowired
    private MsgService service;

    @GetMapping("/welcome")
    public String welcomeMsg(){
        System.out.println(service.getClass().getName());
        String welcomeMsg= service.getWelcomeMsg();
        return welcomeMsg.toUpperCase();
    }

    @GetMapping("/greet")
    public String greetMsg(){
        System.out.println(service.getClass().getName());
        String welcomeMsg= service.getGreetMsg();
        return welcomeMsg.toUpperCase();
    }

}
