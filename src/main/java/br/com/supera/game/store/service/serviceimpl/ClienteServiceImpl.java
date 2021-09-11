package br.com.supera.game.store.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.supera.game.store.repository.ClienteRepository;
import br.com.supera.game.store.service.ClienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoServiceImpl enderecoServiceImpl;
	private ClienteServiceImpl clienteServiceImpl;
	
	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}

	@Override
	public Cliente save(Cliente cliente) {
		if (cliente.getEndereco() == null) {
			return null;
		}
		
		if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
			return null;
		}

		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		if (clienteExistente != null && clienteExistente.getId() != null) {
			return clienteExistente;
		}
		Endereco endereco = enderecoServiceImpl.save(cliente.getEndereco());
		if (endereco == null) {
			return null;
		}
		cliente.setEndereco(endereco);
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente findByEmail(String email) {
		return clienteRepository.findByEmail(email);
	}

}
