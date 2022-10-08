package br.com.ifg.controlefinanca.models.usuario.service;

import br.com.ifg.controlefinanca.models.email.service.EmailAComfimacaoService;
import br.com.ifg.controlefinanca.models.registro.token.entity.ConfirmaToken;
import br.com.ifg.controlefinanca.models.registro.token.service.ConfirmaTokenService;
import br.com.ifg.controlefinanca.models.usuario.Usuario;
import br.com.ifg.controlefinanca.models.email.entity.Email;
import br.com.ifg.controlefinanca.models.usuario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsuarioService implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    private ConfirmaTokenService tokenService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private EmailAComfimacaoService emailConfimacaoService;
    private final static String USER_NOT_FOUND_MSG = "Usuario não encontrado email";

    /** Verifica o se usuario informado no login existe na base de dados */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       return usuarioRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(Usuario usuario){
        verficaUsuario(usuario);
        salvaUsuario(usuario);
        enviaEmailConfimacao(usuario, salvaToken(usuario));
        return "Usuário Cadastrado Confirme seu E-mail";
    }

    public int enableAppUser(String email) {
        return usuarioRepository.enableAppUser(email);
    }

    private void enviaEmailConfimacao(Usuario usuario, String token) {
        String link =  System.getenv().getOrDefault("HOST", "http://localhost:8080") + "/api/v1/registration/confirm?token=" + token;

        Email email = Email.builder()
                .subject("Confirmação de Cadastro")
                .urlConfirme(link)
                .usuario(usuario)
                .build();
        emailConfimacaoService.enviaEmail(email);
    }
    private String salvaToken(Usuario usuario) {
        String token = UUID.randomUUID().toString();
        ConfirmaToken confirmaToken = new ConfirmaToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                usuario
        );
        tokenService.saveConfirmationToken(confirmaToken);
        return token;
    }
    private void salvaUsuario(Usuario usuario) {
        String encodedPassword = bCryptPasswordEncoder
               .encode(usuario.getPassword());

        usuario.setSenha(encodedPassword);

        usuarioRepository.save(usuario);
    }
    private void verficaUsuario(Usuario usuario) {
        Boolean UsuarioExists = usuarioRepository
                 .findByEmail(usuario.getEmail())
                 .isPresent();

        if(UsuarioExists){
            // TODO: Verifcas atributos que devem ser unicos para cada usuário
            // TODO: se o E-mail não for confirmado envie uma confimação por email
            throw new IllegalStateException("Email já utilizado");
        }
    }


}

