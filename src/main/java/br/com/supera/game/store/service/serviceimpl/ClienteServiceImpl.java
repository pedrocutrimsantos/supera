package br.com.supera.game.store.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.supera.game.store.model.Cliente;
import br.com.supera.game.store.model.Endereco;
import br.com.supera.game.store.repository.ClienteRepository;
import br.com.supera.game.store.service.ClienteService;
import br.com.supera.game.store.service.serviceimpl.EndercoServiceImpl.EnderecoServiceImpl;
import java.util.List;
import java.util.Optional;


public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoServiceImpl enderecoServiceImpl;
	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> findById(Long id) {
		return null;
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
