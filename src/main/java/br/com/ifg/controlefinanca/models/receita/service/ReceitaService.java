package br.com.ifg.controlefinanca.models.receita.service;

import br.com.ifg.controlefinanca.models.receita.dto.ReceitaDTO;
import br.com.ifg.controlefinanca.models.receita.entity.Receita;
import br.com.ifg.controlefinanca.models.receita.repository.ReceitaRepository;
import br.com.ifg.controlefinanca.models.usuario.entity.Usuario;
import br.com.ifg.controlefinanca.models.usuario.repository.UsuarioRepository;
import br.com.ifg.controlefinanca.models.util.ModelMapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository repository;

    @Autowired
    private UsuarioRepository UserRepository;
    ModelMapper mapper = ModelMapperUtil.getInstance();


    public List<ReceitaDTO> findAll() {
        List<Receita> tarefas = repository.findByUsuario(findUsuarioBySession());
        return tarefas.stream()
                .map(task -> mapper.map(task, ReceitaDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<ReceitaDTO> findById(Long id) throws IllegalAccessException {
        Optional<Receita> receita = Optional.of(findReceitaById(id));
        Usuario usuario = findUsuarioBySession();
        if(receita.get().getUsuario().equals(usuario)){
            return Optional.of(mapper.map(receita.get(), ReceitaDTO.class));
        }else {
            throw new IllegalAccessException(String.format("%s não possui autorização de acesso a esse recurso", usuario.getNome()));
        }
    }

    public ReceitaDTO create(ReceitaDTO receita) {
        Receita receitaInit = mapper.map(receita, Receita.class);
        receitaInit.setUsuario(findUsuarioBySession());
        Receita receitaSalva = repository.save(receitaInit);
        return mapper.map(receitaSalva, ReceitaDTO.class);
    }

    public ReceitaDTO update(Long id, ReceitaDTO receita) throws IllegalAccessException {
        Receita receitaAtualizada = findReceitaById(id);
        BeanUtils.copyProperties(receita, receitaAtualizada, "id");
        Usuario usuario = findUsuarioBySession();
        if(receitaAtualizada.getUsuario().equals(usuario)){
            return mapper.map(repository.save(receitaAtualizada), ReceitaDTO.class);
        }else {
            throw new IllegalAccessException(String.format("%s não possui autorização de acesso a esse recurso", usuario.getNome()));
        }
    }

    public void delete(Long id) throws IllegalAccessException {
        Receita receita = findReceitaById(id);
        Usuario usuario = findUsuarioBySession();
        if(receita.getUsuario().equals(usuario)){
            repository.deleteById(id);
        }else {
            throw new IllegalAccessException(String.format("%s não possui autorização de acesso a esse recurso", usuario.getNome()));
        }
    }

    private Receita findReceitaById(Long codigo) {
        Receita receita =  repository.findById(codigo).orElse(null);
        if(!Objects.nonNull(receita)){throw new EmptyResultDataAccessException(1);}
        return receita;
    }

    private Usuario findUsuarioBySession() {
        String USER = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario =  UserRepository.findByEmail(USER).orElse(null);
        if(!Objects.nonNull(usuario)){throw new EmptyResultDataAccessException(1);}
        return usuario;
    }
}
