package br.com.ifg.controlefinanca.models.receita.dto;

import br.com.ifg.controlefinanca.models.util.enuns.TipoMoeda;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @TAG BD01
 * Builder - Design Pattern Criacional
 * @Author Carlos Alexandre Fernandes Batista
 * */
public final class ReceitaDTOBuilder {
    private @NotBlank @Size(max = 80) String nome;
    private @NotBlank @Size(max = 200) String descricao;
    private @NotNull LocalDate data;
    private @NonNull BigDecimal valor;
    private @NonNull TipoMoeda moeda;

    private ReceitaDTOBuilder() {
    }

    public static ReceitaDTOBuilder aReceitaDTO() {
        return new ReceitaDTOBuilder();
    }

    public ReceitaDTOBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public ReceitaDTOBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public ReceitaDTOBuilder data(LocalDate data) {
        this.data = data;
        return this;
    }

    public ReceitaDTOBuilder valor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public ReceitaDTOBuilder moeda(TipoMoeda moeda) {
        this.moeda = moeda;
        return this;
    }

    public ReceitaDTO build() {
        ReceitaDTO receitaDTO = new ReceitaDTO(valor, moeda);
        receitaDTO.setNome(nome);
        receitaDTO.setDescricao(descricao);
        receitaDTO.setData(data);
        return receitaDTO;
    }
}
