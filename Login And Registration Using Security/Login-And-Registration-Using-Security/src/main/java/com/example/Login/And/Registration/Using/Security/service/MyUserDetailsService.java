package com.example.Login.And.Registration.Using.Security.service;

import com.example.Login.And.Registration.Using.Security.entity.Customer;
import com.example.Login.And.Registration.Using.Security.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Customer customer= repo.findByUname(username);
      return new User(customer.getUname(),customer.getPwd(), Collections.emptyList());
    }
}
