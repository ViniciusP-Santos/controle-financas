package br.com.ifg.controlefinanca.models.usuario.entity;


import br.com.ifg.controlefinanca.models.receita.entity.Receita;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "USUARIO_APAGAR")
public class UsuarioApagar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate nascimento;
    private String estado;
    private Boolean ativo;
    private LocalDate dataCriacao;
    @OneToOne
    private Role roles;
    @JsonIgnore
    @OneToMany
    private Set<Receita> receita;
//    @OneToMany
//    private Set<Despesa> depesa;
//    @OneToMany
//    private Set<Investimento> investimento;
}
