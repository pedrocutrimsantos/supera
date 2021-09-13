package br.com.supera.game.store.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.supera.game.store.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByEmail(String email);
	Cliente findById(Long id);
	Cliente deleteById(Long id);
}
