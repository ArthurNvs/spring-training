package com.spring.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.assembler.ClienteModelAssembler;
import com.spring.api.exception.ClienteNotFoundException;
import com.spring.api.model.Cliente;
import com.spring.api.repository.ClienteRepository;

@RestController
public class ClienteController {

	private ClienteRepository clienteRepository;
	private ClienteModelAssembler clienteModelAssembler;

	public ClienteController(ClienteRepository clienteRepository, ClienteModelAssembler clienteModelAssembler) {
		this.clienteRepository = clienteRepository;
		this.clienteModelAssembler = clienteModelAssembler;
	}

	@GetMapping("/clientes")
	public CollectionModel<EntityModel<Cliente>> listarClientes() {
		List<EntityModel<Cliente>> clientes = clienteRepository.findAll().stream().map(clienteModelAssembler::toModel)
				.collect(Collectors.toList());
		return CollectionModel.of(clientes, WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ClienteController.class).listarClientes()).withSelfRel());
	}

	@GetMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public EntityModel<Cliente> getClientePorId(@PathVariable Long id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ClienteNotFoundException(id));
		return clienteModelAssembler.toModel(cliente);
	}

	@PostMapping("/clientes")
	public ResponseEntity<?> adicionarCliente(@RequestBody Cliente cliente) {
		EntityModel<Cliente> entityModel = clienteModelAssembler.toModel(clienteRepository.save(cliente));
		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> atualizarCliente(@RequestBody Cliente novoCliente, @PathVariable Long id) {
		Cliente clienteAtualizado = clienteRepository.findById(id).map(cliente -> {
			cliente.setNome(novoCliente.getNome());
			return clienteRepository.save(novoCliente);
		}).orElseGet(() -> {
			novoCliente.setId(id);
			return clienteRepository.save(novoCliente);
		});

		EntityModel<Cliente> entityModel = clienteModelAssembler.toModel(clienteAtualizado);

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> removerCliente(@PathVariable Long id) {
		clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}