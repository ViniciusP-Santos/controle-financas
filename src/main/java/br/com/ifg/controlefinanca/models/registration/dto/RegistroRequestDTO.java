package br.com.ifg.controlefinanca.models.registration.dto;

import br.com.ifg.controlefinanca.models.usuario.Usuario;
import br.com.ifg.controlefinanca.models.usuario.entity.UsuarioRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.OneToMany;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class RegistroRequestDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private UsuarioRole appUserRole;
    private Boolean locked;
    private Boolean enable;
    @OneToMany
    private List<Usuario> usuarios;
}
