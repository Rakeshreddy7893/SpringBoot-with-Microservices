package com.example.Web_Client.Async.service;

import com.example.Web_Client.Async.Post;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


//Asynchronous Requests Using WebClient
@Service
public class QuoteService {

    public  void getQuoteV1(){
        WebClient client = WebClient.create();
        Mono<String> response =client.get()
                .uri("https://jsonplaceholder.typicode.com/posts/1")
                .retrieve()
                .bodyToMono(String.class);
        response.subscribe(System.out::println);
        System.out.println("Hello");

    }

    public  void createQuoteV1(){
        WebClient client = WebClient.create();
        Mono<String> response =client.post()
                .uri("https://jsonplaceholder.typicode.com/posts")
                .body(Mono.just(new Post("foo", "bar", 1)), Post.class)
                .retrieve()
                .bodyToMono(String.class);
        response.subscribe(System.out::println);

    }
    public  void updateQuoteV1(){
        WebClient client = WebClient.create();
        Mono<String> response =client.put()
                .uri("https://jsonplaceholder.typicode.com/posts/1")
                .retrieve()
                .bodyToMono(String.class);
        response.subscribe(System.out::println);

    }
    public  void deleteQuoteV1(){
        WebClient client = WebClient.create();
        Mono<String> response =client.delete()
                .uri("https://jsonplaceholder.typicode.com/posts/1")
                .retrieve()
                .bodyToMono(String.class);
        response.subscribe(System.out::println);

    }

}
