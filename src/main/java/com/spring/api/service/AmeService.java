package com.spring.api.service;

import com.spring.api.premiacao.GatewayPremiacao;
import com.spring.api.util.TipoPremio;

public class AmeService implements GatewayPremiacao {
	
	private String usuario;
	private String senha;
	
	public AmeService(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	@Override
	public void efetuarPremiacao(TipoPremio tipoPremio) {
		System.out.println(usuario + " -- " + senha + " --> AME premiando!");
	}
}
