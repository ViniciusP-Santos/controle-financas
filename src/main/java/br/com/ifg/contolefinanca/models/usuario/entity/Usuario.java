package br.com.ifg.contolefinanca.models.usuario.entity;


import br.com.ifg.contolefinanca.models.receita.entity.Receita;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String email;
    private String senha;
    private LocalDate nascimento;
    private String estado;
    private boolean ativo;
    private LocalDate dataCriacao;
    @JsonIgnore
    @OneToMany
    private Set<Receita> receita;
//    @OneToMany
//    private Set<Despesa> depesa;
//    @OneToMany
//    private Set<Investimento> investimento;


    public static final class UsuarioBuilder {
        private Long id;
        private String nome;
        private String email;
        private String senha;
        private LocalDate nascimento;
        private String estado;
        private boolean ativo;
        private LocalDate dataCriacao;
        private Set<Receita> receita;

        private UsuarioBuilder() {
        }

        public static UsuarioBuilder anUsuario() {
            return new UsuarioBuilder();
        }

        public UsuarioBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UsuarioBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public UsuarioBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UsuarioBuilder senha(String senha) {
            this.senha = senha;
            return this;
        }

        public UsuarioBuilder nascimento(LocalDate nascimento) {
            this.nascimento = nascimento;
            return this;
        }

        public UsuarioBuilder estado(String estado) {
            this.estado = estado;
            return this;
        }

        public UsuarioBuilder ativo(boolean ativo) {
            this.ativo = ativo;
            return this;
        }

        public UsuarioBuilder dataCriacao(LocalDate dataCriacao) {
            this.dataCriacao = dataCriacao;
            return this;
        }

        public UsuarioBuilder receita(Set<Receita> receita) {
            this.receita = receita;
            return this;
        }

        public Usuario build() {
            Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            usuario.setNascimento(nascimento);
            usuario.setEstado(estado);
            usuario.setAtivo(ativo);
            usuario.setDataCriacao(dataCriacao);
            usuario.setReceita(receita);
            return usuario;
        }
    }
}
