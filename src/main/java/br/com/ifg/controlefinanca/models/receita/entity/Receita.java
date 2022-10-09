package br.com.ifg.controlefinanca.models.receita.entity;

import br.com.ifg.controlefinanca.models.usuario.entity.Usuario;
import br.com.ifg.controlefinanca.models.util.enuns.TipoMoeda;
import lombok.Data;

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
    @ManyToOne
    private Usuario usuario;
}
