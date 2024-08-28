package com.recykal.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Rest {
   public void bookTicket(){

       RestTemplate restTemplate = new RestTemplate();

       //GET
       String getUrl = "https://jsonplaceholder.typicode.com/posts";
       ResponseEntity<String> response = restTemplate.getForEntity(getUrl, String.class);
       System.out.println("GET Response:");
       System.out.println(response.getBody());

       //POST
       String postUrl="https://jsonplaceholder.typicode.com/posts";
       String postRequestBody = "{\"title\": \"foo\",\"body\":\"bar\", \"userId\":1}";
       HttpHeaders postHeaders = new HttpHeaders();
       postHeaders.setContentType(MediaType.APPLICATION_JSON);
       HttpEntity<String> postRequest = new HttpEntity<>(postRequestBody,postHeaders);
       ResponseEntity<String>postResponse = restTemplate.postForEntity(postUrl,postRequest,String.class);
       System.out.println("POST Response:");
       System.out.println(postResponse.getBody());

       //POST
       String putUrl = "https://jsonplaceholder.typicode.com/posts/1";
       String putRequestBody = "{\"id\":1, \"title\":\"foo\",\"body\": \"bar\", \"userId\":1}";
       HttpHeaders putHeaders = new HttpHeaders();
       putHeaders.setContentType(MediaType.APPLICATION_JSON);
       HttpEntity<String>putRequest = new HttpEntity<>(putRequestBody,putHeaders);
       ResponseEntity<String>putResponse = restTemplate.postForEntity(postUrl,putRequest,String.class);
       System.out.println("POST Response:");
       System.out.println("putResponse = " + putResponse);

       //DELETE
       String deleteUrl = "https://jsonplaceholder.typicode.com/posts/1";
       restTemplate.delete(deleteUrl);
       System.out.println("DELETE Request completed for URL: " + deleteUrl);

   }

}
