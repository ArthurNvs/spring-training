package com.spring.api.service;

import com.spring.api.premiacao.GatewayPremiacao;
import com.spring.api.util.TipoPremio;

public class DotzService implements GatewayPremiacao{

	@Override
	public void efetuarPremiacao(TipoPremio tipoPremio) {
		System.out.println("Dotz service, premiando!");
	}

}
