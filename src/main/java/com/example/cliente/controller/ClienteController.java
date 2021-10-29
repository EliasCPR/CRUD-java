package com.example.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.cliente.model.Cliente;
import com.example.cliente.repository.ClienteRepository;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private ClienteRepository cp;
	
	@GetMapping("/clientes")
	public List<Cliente> listaClientes(){
		return cp.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente getCliente(@PathVariable Long id) {
		return cp.findById(id).get();
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@RequestBody Cliente cliente) {
		return cp.save(cliente);
	}
	
	@PutMapping("/clientes")
	public Cliente atualizar(@RequestBody Cliente cliente) {
		return cp.save(cliente);
	}
	
	@DeleteMapping("/clientes/{id}")
	public void excluir(@PathVariable Long id) {
		cp.deleteById(id);
	}
}
