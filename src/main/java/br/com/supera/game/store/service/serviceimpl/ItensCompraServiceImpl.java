package br.com.supera.game.store.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import br.com.supera.game.store.model.ItensCompra;
import br.com.supera.game.store.repository.ItensCompraRepository;
import br.com.supera.game.store.service.ItensCompraService;

public class ItensCompraServiceImpl implements ItensCompraService {
	@Autowired
	ItensCompraRepository ItensCompraCompraRepository;
	

	@Override
	public List<ItensCompra> findAll() {
		return ItensCompraCompraRepository.findAll();
	}
	private Sort sortByIdAsc() {
		return new Sort(Sort.Direction.DESC, "id");
	}



	@Override
	public ItensCompra save(ItensCompra itemCompra) {
		return ItensCompraCompraRepository.save(itemCompra);
	}
	@Override
	public ItensCompra findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}