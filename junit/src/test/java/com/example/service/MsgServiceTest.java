package com.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
class MsgServiceTest {

    @Autowired
    private MsgService msgService;

    @Test
    public void testWelcomeMsg(){
        String welcomMsg = msgService.getWelcomeMsg();
        assertNotNull(welcomMsg);
    }

    @Test
    public void testGreetMsg(){
        String greetMsg = msgService.getWelcomeMsg();
        assertNotNull(greetMsg);
    }


}