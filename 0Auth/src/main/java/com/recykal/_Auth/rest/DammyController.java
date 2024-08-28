package com.recykal._Auth.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DammyController {

     @GetMapping("/")
     public String getMsg(){
       return "Welcome to Ashok It";
     }
}
