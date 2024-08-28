package com.example.service;

import com.example.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.SplittableRandom;

@Service
public class UserService {

    @Autowired(required = false)
    private UserDao userDao;


    public String getUsername(Integer uid){
        String findName = userDao.findName(uid);
        return findName;
    }


}
