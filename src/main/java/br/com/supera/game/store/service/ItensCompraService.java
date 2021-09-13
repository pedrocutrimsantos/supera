package br.com.supera.game.store.service;

import java.util.List;
import br.com.supera.game.store.model.ItensCompra;

public interface ItensCompraService {
	List<ItensCompra> findAll();

	ItensCompra findById(long id);

	ItensCompra save(ItensCompra itensCompra);

}
