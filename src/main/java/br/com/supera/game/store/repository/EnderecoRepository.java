package br.com.supera.game.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.supera.game.store.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
