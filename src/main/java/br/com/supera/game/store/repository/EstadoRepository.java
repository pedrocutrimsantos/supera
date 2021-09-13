package br.com.supera.game.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.supera.game.store.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
	Estado findByNome(String nome);
	Estado findById(Long id);

}
