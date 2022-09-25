package br.com.ifg.contolefinanca.models.receita.repository;

import br.com.ifg.contolefinanca.models.receita.entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
