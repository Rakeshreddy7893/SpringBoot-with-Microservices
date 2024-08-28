package com.example.service;

import com.example.Post;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebClientService {

     WebClient webClient= WebClient.create();

    public void getPost(){
        String getUrl = "https://jsonplaceholder.typicode.com/posts/1";
        String response=  webClient.get()
                 .uri(getUrl)
                 .retrieve()
                 .bodyToMono(String.class)
                 .block();//If you don't Mention  this method then it will be Async
        System.out.println("GET response = " + response);
    }

    public void createPost(){
        String postUrl = "https://jsonplaceholder.typicode.com/posts";
        String response =webClient.post()
                .uri(postUrl)
                .bodyValue(new Post("foo","bar",1))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("POST response = " + response);
    }

    public void updatePost(){
        String updateUrl = "https://jsonplaceholder.typicode.com/posts/1";
        String response = webClient.put()
                .uri(updateUrl)
                .bodyValue(new Post(1,"Updated title","Updated body",1))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("UPDATE response = " + response);

    }

    public void deletePost(){
        String deleteUrl = "https://jsonplaceholder.typicode.com/posts/1";
        String response = webClient.delete()
                .uri(deleteUrl)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        System.out.println(" DELETE response = " + response);
    }





}
