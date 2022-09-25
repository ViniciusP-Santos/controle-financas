package br.com.ifg.contolefinanca.models.receita.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class ReceitaDTO {
    @NotBlank
    @Size(max = 80)
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    private LocalDate data;
    @NonNull
    private BigDecimal valor;
}
