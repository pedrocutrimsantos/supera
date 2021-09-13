package br.com.supera.game.store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/iniciar")
public class PrincipalController {

	@RequestMapping("/")
	public String index() {
		return "post";
	}

	@GetMapping("/administrativo")
	public String acessarPrincipal() {
		return "administrativo/home";
	}
}
