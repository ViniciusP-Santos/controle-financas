package br.com.ifg.contolefinanca.models.usuario.entity;


import br.com.ifg.contolefinanca.models.receita.entity.Receita;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate nascimento;
    private String estado;
    private boolean ativo;
    @OneToMany
    private Set<Receita> receita;
//    @OneToMany
//    private Set<Despesa> depesa;
//    @OneToMany
//    private Set<Investimento> investimento;
}
