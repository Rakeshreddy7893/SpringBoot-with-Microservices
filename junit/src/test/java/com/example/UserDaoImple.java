package com.example;

import com.example.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImple implements UserDao {
    @Override
    public String findName(Integer uid) {
        return "John";
    }
}
