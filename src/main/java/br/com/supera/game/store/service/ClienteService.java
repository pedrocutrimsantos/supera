package br.com.supera.game.store.service;

import java.util.List;
import java.util.Optional;

import br.com.supera.game.store.model.Cliente;
public interface ClienteService {
	
	
	List<Cliente> findAll();

	Optional<Cliente> findById(Long id);

	Cliente save(Cliente cliente);

	Cliente findByEmail(String email);
}