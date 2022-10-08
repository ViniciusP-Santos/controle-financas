package br.com.ifg.controlefinanca.models.util.cotacao.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class DolarCotacaoDTO {
    String nome;
    String sigla;
    BigDecimal valorReal;
    BigDecimal valorDolar;
}
