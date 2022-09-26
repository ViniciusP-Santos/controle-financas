package br.com.ifg.contolefinanca.models.config.security.service;

import br.com.ifg.contolefinanca.models.config.security.UserSS;
import br.com.ifg.contolefinanca.models.usuario.entity.Usuario;
import br.com.ifg.contolefinanca.models.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> user = usuarioRepository.findByEmail(email);
        if(user.isPresent()){
            return new UserSS(
                    user.get().getId(),
                    user.get().getEmail(),
                    user.get().getSenha(),
                    null);
        }
        throw new UsernameNotFoundException(email);
    }
}
