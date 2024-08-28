package com.recykal.Greet_API.rest;

import com.recykal.Greet_API.client.WelcomeApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {

    @Autowired
    private WelcomeApiClient welcomApiClient;

    @GetMapping("/greet")
    public String getGreetMsg(){
        String welcomeMsg=welcomApiClient.invokeWelcomeMsg();
        String greetMsg = "Good Morning";
        return  greetMsg.concat(" "+welcomeMsg);
    }
}
