package br.com.supera.game.store.service;

import java.util.List;
import br.com.supera.game.store.model.Product;

public interface ProductService {

	List<Product> findAll();

	Product find(long id);

	Product save(Product product);

}
