package br.com.supera.game.store.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.repository.ProductRepository;
import br.com.supera.game.store.service.serviceimpl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/product")
public class ProductController {


	private ProductServiceImpl ProductServiceImpl;
	@Autowired
	ProductRepository productRepository;
		

	@GetMapping("/administrativo/produtos/cadastrar")
	public ModelAndView cadastrar(Product produto) {
		ModelAndView mv = new ModelAndView("administrativo/produtos/cadastro");
		mv.addObject("produto", produto);
		return mv;
	}

	@GetMapping("/administrativo/produtos/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/produtos/lista");
		mv.addObject("listaProdutos", productRepository.findAll());
		return mv;
	}

	@GetMapping("/administrativo/produtos/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Product> product = Optional.ofNullable(productRepository.findById(id));
		return cadastrar(product.get());
	}

	@GetMapping("/administrativo/produtos/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Product> product = Optional.ofNullable(productRepository.findById(id));
		productRepository.delete(product.get());
		return listar();
	}

	@GetMapping("/listarproduto")
	public ResponseEntity<List<Product>> listarw() {
		List<Product> produtos = ProductServiceImpl.findAll();
		return new ResponseEntity<List<Product>>(produtos,HttpStatus.OK);
	}
	
	@PostMapping("/salvarproduto")
	public ResponseEntity<Product> salvar(@RequestBody Product product) {
		Product c = ProductServiceImpl.save(product);
		return new ResponseEntity<Product>(c,HttpStatus.OK);
	}

}
