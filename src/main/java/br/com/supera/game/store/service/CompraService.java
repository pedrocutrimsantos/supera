package br.com.supera.game.store.service;
import java.util.List;
import br.com.supera.game.store.model.Venda;

public interface CompraService {

	List<Venda> findAll();

	Venda findById(long id);

	Venda save(Venda compra);

}
