package br.com.ifg.contolefinanca.models.usuario.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
public class UsuarioDTO {
    @NotBlank
    @Size(max = 80)
    private String nome;
    @NotNull
    private LocalDate nascimento;
    @NotBlank
    private String estado;
}
