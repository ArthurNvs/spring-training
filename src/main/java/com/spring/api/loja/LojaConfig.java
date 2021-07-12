package com.spring.api.loja;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.spring.api.service.AmeService;
import com.spring.api.service.DotzService;

@Configuration
public class LojaConfig {
	
	@Bean
	public AmeService ameService() {
		return new AmeService("teste", "p455w0rd");
	}
	
	@Bean
	@Primary
	public DotzService dotzService() {
		return new DotzService();
	}
	
//Utilizar o @Component em PremiarClienteService funciona da mesma forma
//	@Bean
//	public PremiarClienteService premiarClienteService(GatewayPremiacao gateway) {
//		return new PremiarClienteService(gateway);
//	}
}