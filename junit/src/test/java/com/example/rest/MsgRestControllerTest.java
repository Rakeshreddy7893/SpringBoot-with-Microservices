package com.example.rest;

import com.example.service.MsgService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = MsgRestController.class)
class MsgRestControllerTest {

    @MockBean
    private MsgService msgService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public  void testGreetMsg() throws  Exception{
        when(msgService.getGreetMsg()).thenReturn("Dummy Text");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greet");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        int status = response.getStatus();
        assertEquals(200,status);

    }


    @Test
    public void testWelcomeMsg() throws  Exception{
        when(msgService.getWelcomeMsg()).thenReturn("Good evening...");  //Defining the behaviour of Object method
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome");
        MvcResult  result =   mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String contentAsString = response.getContentAsString();
        System.out.println("contentAsString = " + contentAsString);
        int status = response.getStatus();
        assertEquals(200,status);
    }


}