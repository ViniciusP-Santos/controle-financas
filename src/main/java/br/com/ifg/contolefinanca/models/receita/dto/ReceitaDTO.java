package br.com.ifg.contolefinanca.models.receita.dto;

import br.com.ifg.contolefinanca.models.util.TipoMoeda;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class ReceitaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    @Size(max = 80)
    private String nome;
    @NotBlank
    @Size(max = 200)
    private String descricao;
    @NotNull
    private LocalDate data;
    @NonNull
    private BigDecimal valor;
    @NonNull
    private TipoMoeda moeda;
}
