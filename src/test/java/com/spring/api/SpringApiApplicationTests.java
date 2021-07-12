package com.spring.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.api.model.Cliente;
import com.spring.api.util.TipoPremio;

@SpringBootTest
class SpringApiApplicationTests {
	
	private MockPremiarClienteService premiarClienteService;
	
	@Test
	void registrarCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("Testeley");
		
		premiarClienteService = new MockPremiarClienteService();
		premiarClienteService.efetuarPremiacao(TipoPremio.CASHBACK);
	}
}