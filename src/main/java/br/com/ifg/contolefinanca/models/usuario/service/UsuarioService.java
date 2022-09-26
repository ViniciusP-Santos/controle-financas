package br.com.ifg.contolefinanca.models.usuario.service;

import br.com.ifg.contolefinanca.models.usuario.dto.UsuarioDTO;
import br.com.ifg.contolefinanca.models.usuario.entity.Usuario;
import br.com.ifg.contolefinanca.models.usuario.repository.UsuarioRepository;
import br.com.ifg.contolefinanca.models.util.ModelMapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UsuarioService {

    //TODO: Finalizar desenvolvimento de service.
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    ModelMapper MAPPER = ModelMapperUtil.getInstance();

    /**Teste EndPoint*/
    public Usuario createUsuario(UsuarioDTO usuario) {
        Usuario teste = repository.save(Usuario.UsuarioBuilder
                .anUsuario()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(encoder.encode(usuario.getSenha()))
                .nascimento(usuario.getNascimento())
                .estado(usuario.getEstado())
                .dataCriacao(LocalDate.now())
                .build());
        return teste;
    }
}
