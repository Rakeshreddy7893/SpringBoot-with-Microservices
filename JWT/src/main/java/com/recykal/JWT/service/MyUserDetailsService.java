package com.recykal.JWT.service;

import com.recykal.JWT.entity.UserEntity;
import com.recykal.JWT.repository.UserEntityRepository;
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
    private UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user=userEntityRepository.findByUname(username);
        return new User(user.getUname(),user.getUpwd(), Collections.emptyList());
    }

    public  boolean saveUser(UserEntity user){
        user = userEntityRepository.save(user);
        return user.getUserId()!=null;
    }




}
