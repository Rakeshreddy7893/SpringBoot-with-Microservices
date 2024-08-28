package com.recykal.JWT.rest;

import com.recykal.JWT.binding.AuthRequest;
import com.recykal.JWT.entity.UserEntity;
import com.recykal.JWT.service.JwtService;
import com.recykal.JWT.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserEntity user){
       String encodedPwd = passwordEncoder.encode(user.getUpwd());
       user.setUpwd(encodedPwd);
      boolean saveUser= userDetailsService.saveUser(user);
      if(saveUser){
          return "User Registered!!";
      }
      return "Registration failed!!";
    }

    @PostMapping("/login")
    public  String userAuthentication(@RequestBody AuthRequest authRequest){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authRequest.getUname(),authRequest.getPwd());

        try {
            Authentication authentication = manager.authenticate(usernamePasswordAuthenticationToken);

            if (authentication.isAuthenticated()) {
                return  jwtService.generateToken(authRequest.getUname());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       return "Authentication Failed";
    }

    @GetMapping("/welcome")
    public String welcomeMsg(){
        return "Welcome to Ashok IT";
    }

    @GetMapping("/greet")
    public String greetMsg(){
        return "Good Night!!!";
    }





}
