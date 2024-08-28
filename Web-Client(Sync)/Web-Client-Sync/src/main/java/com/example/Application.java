package com.example;

import com.example.service.WebClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =SpringApplication.run(Application.class, args);

		WebClientService webClientService = context.getBean(WebClientService.class);
		webClientService.createPost();
		webClientService.getPost();
		webClientService.updatePost();
		webClientService.deletePost();
	}


}
