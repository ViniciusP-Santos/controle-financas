package br.com.ifg.controlefinanca.models.usuario;

import br.com.ifg.controlefinanca.models.receita.entity.Receita;
import br.com.ifg.controlefinanca.models.usuario.entity.UsuarioRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@Builder
@Table(name = "USUARIO")
public class Usuario implements UserDetails {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate nascimento;
    private String estado;
    private LocalDate dataCriacao;
    @Enumerated(EnumType.STRING)
    private UsuarioRole role;
    private Boolean locked = false;
    private Boolean enable = false;

    @OneToMany
    private Set<Receita> receita;


    public Usuario(String email, String senha, UsuarioRole role) {
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    public Usuario() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authorities = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authorities);
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }
}
