package br.com.supera.game.store.service.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supera.game.store.model.Endereco;
import br.com.supera.game.store.repository.EnderecoRepository;
import br.com.supera.game.store.service.EnderecoService;

public class EndercoServiceImpl {
	@Service
	public class EnderecoServiceImpl implements EnderecoService {
		@Autowired
		EnderecoRepository enderecoRepository;
		
		public List<Endereco> findAll() {
			return enderecoRepository.findAll();
		}
			
		@Override
		public Endereco save(Endereco endereco) {
			if (endereco.getBairro() == null || endereco.getCep().isEmpty()) {
				return null;
			}
			return enderecoRepository.save(endereco);

		}
	}
}