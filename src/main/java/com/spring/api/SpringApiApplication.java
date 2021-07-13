package com.spring.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.api.service.PremiarClienteService;

@SpringBootApplication
public class SpringApiApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(SpringApiApplication.class, args);
		
		PremiarClienteService service = appContext.getBean(PremiarClienteService.class);
		
		service.premiar();
	}
}
