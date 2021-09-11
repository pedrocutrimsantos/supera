package br.com.supera.game.store.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.supera.game.store.model.Cliente;
import br.com.supera.game.store.service.serviceimpl.ClienteServiceImpl;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteServiceImpl clienteServiceImpl;
	
	@GetMapping("/listar/{email}")
	public ResponseEntity<Cliente> listar(@RequestParam("email") String email) {
		System.out.println(email);
		Cliente clientes = clienteServiceImpl.findByEmail(email);
		System.out.println(clientes.getId());
		return new ResponseEntity<Cliente>(clientes,HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> clientes = clienteServiceImpl.findAll();
		return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
		Cliente c = clienteServiceImpl.save(cliente);
		return new ResponseEntity<Cliente>(c,HttpStatus.OK);
	}

}
