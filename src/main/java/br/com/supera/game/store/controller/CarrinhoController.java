package br.com.supera.game.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.supera.game.store.model.Cliente;
import br.com.supera.game.store.model.ItensCompra;
import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.model.Venda;
import br.com.supera.game.store.repository.ItensCompraRepository;
import br.com.supera.game.store.repository.ProductRepository;
import br.com.supera.game.store.repository.VendaRepository;

@RestController
@RequestMapping("/CarrinhoController")
public class CarrinhoController {
	private List<ItensCompra> itensCompra = new ArrayList<ItensCompra>();
	private Venda compra = new Venda();
	private Cliente cliente;

	@Autowired
	private ProductRepository repositoryProduct;

	@Autowired
	private VendaRepository repositoryCompra;

	@Autowired
	private ItensCompraRepository repositorioItensCompra;

	private void calcularTotal() {
		compra.setValorTotal(0.);
		for (ItensCompra it : itensCompra) {
			compra.setValorTotal(compra.getValorTotal() + it.getValorTotal());
		}
	}

	@RequestMapping(value = "/carrinho", method = RequestMethod.GET)
	public ModelAndView chamarCarrinho() {
		ModelAndView mv = new ModelAndView("cliente/carrinho");
		calcularTotal();
		// System.out.println(compra.getValorTotal());
		mv.addObject("compra", compra);
		mv.addObject("listaItens", itensCompra);
		return mv;
	}

	
	

	@GetMapping("/finalizar/")
	public ModelAndView finalizarCompra() {
			ModelAndView mv = new ModelAndView("cliente/finalizar");
		calcularTotal();
		// System.out.println(compra.getValorTotal());
		mv.addObject("compra", compra);
		mv.addObject("listaItens", itensCompra);
		mv.addObject("cliente", cliente);
		return mv;
	}

	@PostMapping("/finalizar/confirmar/")
	public ModelAndView confirmarCompra(String formaPagamento) {
		ModelAndView mv = new ModelAndView("cliente/mensagemFinalizou");
		compra.setCliente(cliente);
		compra.setFormaPagamento(formaPagamento);
		repositoryCompra.saveAndFlush(compra);

		for (ItensCompra c : itensCompra) {
			c.setCompra(compra);
			repositorioItensCompra.saveAndFlush(c);
		}
		itensCompra = new ArrayList<>();
		compra = new Venda();
		return mv;
	}

	@GetMapping("/alterarQuantidade/{id}/{acao}")
	public String alterarQuantidade(@PathVariable Long id, @PathVariable Integer acao) {

		for (ItensCompra it : itensCompra) {
			if (it.getProduct().getId().equals(id)) {
				// System.out.println(it.getValorTotal());
				if (acao.equals(1)) {
					it.setQuantidade(it.getQuantidade() + 1);
					it.setValorTotal(0.);
					it.setValorTotal(it.getValorTotal() + (it.getQuantidade() * it.getValorUnitario()));
				} else if (acao == 0) {
					it.setQuantidade(it.getQuantidade() - 1);
					it.setValorTotal(0.);
					it.setValorTotal(it.getValorTotal() + (it.getQuantidade() * it.getValorUnitario()));
				}
				break;
			}
		}

		return "redirect:/carrinho";
	}

	@GetMapping("/removerProduto/{id}")
	public String removerProdutoCarrinho(@PathVariable Long id) {

		for (ItensCompra it : itensCompra) {
			if (it.getProduct().getId().equals(id)) {
				itensCompra.remove(it);
				break;
			}
		}

		return "redirect:/carrinho";
	}

	@GetMapping("/adicionarCarrinho/{id}")
	public String adicionarCarrinho(@PathVariable Long id) {

		Optional<Product> prod = Optional.ofNullable(repositoryProduct.findById(id));
		Product product = prod.get();

		int controle = 0;
		for (ItensCompra it : itensCompra) {
			if (it.getProduct().getId().equals(product.getId())) {
				it.setQuantidade(it.getQuantidade() + 1);
				it.setValorTotal(0.);
				it.setValorTotal(it.getValorTotal() + (it.getQuantidade() * it.getValorUnitario()));
				controle = 1;
				break;
			}
		}
		if (controle == 0) {
			ItensCompra item = new ItensCompra();
			item.setProduto(product);
			item.setValorUnitario(product.getValorVenda());
			item.setQuantidade(item.getQuantidade() + 1);
			item.setValorTotal(item.getValorTotal() + (item.getQuantidade() * item.getValorUnitario()));

			itensCompra.add(item);
		}

		return "redirect:/carrinho";
	}

}