package br.com.ifg.contolefinanca.models.usuario.repository;

import br.com.ifg.contolefinanca.models.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
