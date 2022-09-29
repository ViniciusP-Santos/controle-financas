package br.com.ifg.controlefinanca.models.registration.service;

import br.com.ifg.controlefinanca.models.registration.dto.RegistroRequestDTO;
import br.com.ifg.controlefinanca.models.registration.entity.EmailValidator;
import br.com.ifg.controlefinanca.models.registration.token.entity.ConfirmaToken;
import br.com.ifg.controlefinanca.models.registration.token.service.ConfirmaTokenService;
import br.com.ifg.controlefinanca.models.usuario.Usuario;
import br.com.ifg.controlefinanca.models.usuario.entity.UsuarioRole;
import br.com.ifg.controlefinanca.models.usuario.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
@AllArgsConstructor
public class RegistroService {
    //TODO: Criar Singleton para E-mail Validator
    private EmailValidator emailValidator;
    private UsuarioService usuarioService;
    private final ConfirmaTokenService confirmaTokenService;


    public String register(RegistroRequestDTO request) {
        Boolean isValidEmail = emailValidator
                .test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("O E-mail não é válido!");
        }
        return usuarioService.cadastraUsuario(
                Usuario.builder()
                        .nome(request.getNome())
                        .email(request.getEmail())
                        .senha(request.getSenha())
                        .role(UsuarioRole.USER)
                        .build());
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmaToken confirmaToken = confirmaTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("Token não encontrado"));

        if (Objects.isNull(confirmaToken.getConfirmadoEm())) {
            throw new IllegalStateException("O E-mail já foi confimado");
        }

        LocalDateTime expiredAt = confirmaToken.getExpiraEm();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Token expirado");
        }

        confirmaTokenService.setConfirmedAt(token);
        usuarioService.ativaUsuario(
                confirmaToken.getUsuario().getEmail());
        return "E-mail Confirmado";
    }
}
