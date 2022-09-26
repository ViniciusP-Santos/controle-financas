package br.com.ifg.contolefinanca.models.receita.entity;

import br.com.ifg.contolefinanca.models.util.TipoMoeda;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "RECEITA")
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate data;
    private BigDecimal valor;
    private TipoMoeda moeda;
}
