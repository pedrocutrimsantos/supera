package br.com.supera.game.store.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.supera.game.store.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByEmail(String email);
	Cliente findById(Long id);
}
