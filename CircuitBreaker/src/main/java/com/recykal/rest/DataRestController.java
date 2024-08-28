package com.recykal.rest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataRestController {

    @GetMapping("/data")
    @CircuitBreaker(fallbackMethod = "getDataFromDb",name ="Rakesh")
    public String getData(){
        System.out.println("redis method called");
        int i=10/0;
        return "Redis Data Sent to email";
    }

    public String getDataFromDb(Throwable t){
        System.out.println("Db method called");
        return "DB Data Sent to email";
    }
}
