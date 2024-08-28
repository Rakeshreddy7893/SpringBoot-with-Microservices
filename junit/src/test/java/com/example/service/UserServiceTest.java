package com.example.service;

import com.example.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(value = {MockitoExtension.class})
class UserServiceTest {

    @MockBean
    private UserDao userDao;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUsername(){
        when(userDao.findName(101)).thenReturn("Rakesh");
      String username=userService.getUsername(101);
      assertNotNull(username);
    }

}