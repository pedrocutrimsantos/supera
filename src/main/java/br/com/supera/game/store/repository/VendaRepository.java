package br.com.supera.game.store.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.supera.game.store.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
