package com.example.Web_Client.Async;

import com.example.Web_Client.Async.service.QuoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(Application.class, args);

		QuoteService service = context.getBean(QuoteService.class);
		service.createQuoteV1();
		service.getQuoteV1();
		service.updateQuoteV1();
		service.deleteQuoteV1();
	}

}
