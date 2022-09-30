package br.com.ifg.controlefinanca.models.registration.dto;

import br.com.ifg.controlefinanca.models.usuario.Usuario;
import br.com.ifg.controlefinanca.models.usuario.enuns.UsuarioRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.OneToMany;
import java.time.LocalDate;
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
    private LocalDate nascimento;
    private String estado;
}
