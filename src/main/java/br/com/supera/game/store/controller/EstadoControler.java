package br.com.supera.game.store.controller;

import javax.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import br.com.supera.game.store.model.Estado;
import br.com.supera.game.store.repository.EstadoRepository;

public class EstadoControler {

	@RequestMapping("/")
	public String index() {
		return "post";
	}

	@Autowired
	private EstadoRepository estadoRepositoryImpl;
	@Autowired
	private EstadoRepository estadoRepositorio;

	@GetMapping("/listar/{Estado}")
	public ResponseEntity<Estado> listar(@RequestParam("nome") String nome) {
		System.out.println(nome);
		Estado estado = estadoRepositoryImpl.findByNome(nome);
		System.out.println(estado.getId());
		return new ResponseEntity<Estado>(estado, HttpStatus.OK);
	}

	@PostMapping("/administrativo/estados/salvar")
	public ModelAndView salvar(@Valid Estado estado, BindingResult result) {

		if (result.hasErrors()) {
			return cadastrar(estado);
		}
		estadoRepositorio.saveAndFlush(estado);

		return cadastrar(new Estado());
	}

	private ModelAndView cadastrar(@Valid Estado estado) {
		// TODO Auto-generated method stub
		return null;
	}

}
