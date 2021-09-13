package br.com.supera.game.store.service;

import java.util.List;
import br.com.supera.game.store.model.Estado;

public interface EstadoService {

	List<Estado> findAll();

	Estado findById(long id);

	Estado save(Estado estado);
}
