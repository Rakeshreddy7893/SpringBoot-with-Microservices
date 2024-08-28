package com.recykal.Greet_API.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "WELCOME-API")
public interface WelcomeApiClient {

    @GetMapping("/welcome")
    public String invokeWelcomeMsg();
}
