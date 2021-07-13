package com.spring.api.service;

import org.springframework.stereotype.Component;

import com.spring.api.premiacao.GatewayPremiacao;
import com.spring.api.util.TipoPremio;

@Component
public class PremiarClienteService {
	
	private GatewayPremiacao gatewayPremiacao;
	
	public PremiarClienteService(GatewayPremiacao gatewayPremiacao) {
		this.gatewayPremiacao = gatewayPremiacao;
	}
	
	public void premiar() {
		gatewayPremiacao.efetuarPremiacao(TipoPremio.DINHEIRO);
	}
	
	//serve para injetar dependência pelo Spring
	//porém aqui complica um pouco a parte de testes
//	@Autowired
//	public void setGatewayPremiacao(GatewayPremiacao gateway) {
//		this.gatewayPremiacao = gateway;
//	}
}