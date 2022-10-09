package br.com.ifg.controlefinanca.models.receita.dto;

import br.com.ifg.controlefinanca.models.usuario.entity.Usuario;
import br.com.ifg.controlefinanca.models.util.enuns.TipoMoeda;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @TAG DTO01
 * Data Transfer Object - Design Pattern
 * @Author Carlos Alexandre Fernandes Batista
 * */
@Data
public class ReceitaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    @NotBlank
    @Size(max = 80)
    private String nome;
    @NotBlank
    @Size(max = 200)
    private String descricao;
    @NotNull
    private LocalDate data;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private TipoMoeda moeda;
    private Usuario usuario;
}
