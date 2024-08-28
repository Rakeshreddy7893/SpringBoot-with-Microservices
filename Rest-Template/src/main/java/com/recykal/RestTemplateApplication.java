package com.recykal;

import com.recykal.service.Rest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestTemplateApplication  {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(RestTemplateApplication.class, args);
		Rest rest = context.getBean(Rest.class);
		rest.bookTicket();
	}



}
