package br.com.supera.game.store.service.serviceimpl;

import java.util.List;

import org.springframework.data.domain.Sort;

import br.com.supera.game.store.model.Estado;
import br.com.supera.game.store.repository.EstadoRepository;
import br.com.supera.game.store.service.EstadoService;

public class EstadoServiceImp implements EstadoService{

	EstadoRepository estadoRepository;

	public List<Estado> findAll() {
		return estadoRepository.findAll(sortByIdAsc());
	}

	private Sort sortByIdAsc() {
		return new Sort(Sort.Direction.DESC, "id");
	}

	@Override
	public Estado findById(long id) {
		return estadoRepository.findById(id);
	}

	@Override
	public Estado save(Estado estado) {
		return estadoRepository.save(estado);
	}

}