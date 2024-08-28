package com.example.Login.And.Registration.Using.Security.rest;

import com.example.Login.And.Registration.Using.Security.entity.Customer;
import com.example.Login.And.Registration.Using.Security.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {

    @Autowired
    private CustomerRepository crepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String registerCustomer(@RequestBody Customer customer){
     customer.setPwd(encoder.encode(customer.getPwd()));
     crepo.save(customer);
     return "User Registered";
    }

    @PostMapping("/login")
    public String loginCheck(@RequestBody Customer customer){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(customer.getUname(),customer.getPwd());
        Authentication authenticate=authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if(authenticate.isAuthenticated()){
            return "Welcome to Ashok It";
        }
        return "Invalid Credentials";
    }


}
