package br.com.supera.game.store.service.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.repository.ProductRepository;
import br.com.supera.game.store.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product save(Product product) {
		if (product.getPrice() == null) {
			return null;
		}
		if (product.getImage() == null) {
			return null;
		}
		return productRepository.save(product);
	}
	}


