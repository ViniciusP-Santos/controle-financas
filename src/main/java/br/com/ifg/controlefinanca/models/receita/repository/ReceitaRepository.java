package br.com.ifg.controlefinanca.models.receita.repository;

import br.com.ifg.controlefinanca.models.receita.entity.Receita;
import br.com.ifg.controlefinanca.models.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

//    @Query("SELECT r FROM Receita r WHERE r.usuario.email = :email")
    List<Receita> findByUsuario(Usuario usuario);
}
