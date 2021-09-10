package br.com.supera.game.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.supera.game.store.service.ProductService;

@RestController
@RequestMapping("/Post")
@CrossOrigin(origins="*")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping("/")
	public String index() {
	return "product";
	}
	
}
