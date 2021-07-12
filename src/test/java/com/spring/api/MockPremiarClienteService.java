package com.spring.api;

import com.spring.api.premiacao.GatewayPremiacao;
import com.spring.api.util.TipoPremio;

public class MockPremiarClienteService implements GatewayPremiacao {

	@Override
	public void efetuarPremiacao(TipoPremio tipoPremio) {
		System.out.println("teste ok premiando.");

	}

}
