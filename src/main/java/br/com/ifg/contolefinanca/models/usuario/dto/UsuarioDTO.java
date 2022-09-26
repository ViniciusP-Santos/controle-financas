package br.com.ifg.contolefinanca.models.usuario.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    @Size(max = 80)
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
    @NotNull
    private LocalDate nascimento;
    @NotBlank
    private String estado;
    private boolean ativo;
}
