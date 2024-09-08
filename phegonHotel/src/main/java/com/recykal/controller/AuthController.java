package com.recykal.controller;

import com.recykal.dto.LoginRequest;
import com.recykal.dto.Response;
import com.recykal.entity.User;
import com.recykal.service.interfaces.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IUserServices userServices;

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody User user){
        Response response = userServices.register(user);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }


    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody LoginRequest loginRequest){
        Response response = userServices.login(loginRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }



}
