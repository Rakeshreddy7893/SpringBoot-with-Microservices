package com.recykal.Security_Http_Basic_Auth.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

    @GetMapping("/contact")
    public String getContactUs(){
        return "Contact +91-0000000000!";
    }

    @GetMapping("/aboutus")
    public String getAboutUs(){
        return "AboutUs!";
    }

    @GetMapping("/greet")
    public String getGreetMsg(){
        return "Good Morning!";
    }

    @GetMapping("/welcome")
    public String getWelcomeMsg(){
        return "Welcome To AshokIt..!";
    }


}
