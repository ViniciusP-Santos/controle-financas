package br.com.ifg.controlefinanca.models.receita.repository;

import br.com.ifg.controlefinanca.models.receita.entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
