package br.com.ifg.contolefinanca.controllers.usuario;

import br.com.ifg.contolefinanca.models.usuario.dto.UsuarioDTO;
import br.com.ifg.contolefinanca.models.usuario.entity.Usuario;
import br.com.ifg.contolefinanca.models.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<String> findAll(){
        return ResponseEntity.ok().body("OK");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@NotBlank @PathVariable("id") Long id){
        return ResponseEntity.ok().body("OK");
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@Valid @RequestBody UsuarioDTO usuario){
        Usuario teste = usuarioService.createUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(teste);
    }

    @PutMapping("/{codigo}/ativo")
    public ResponseEntity<String> activate(@PathVariable Long codigo, @RequestBody Boolean ativo){
        return ResponseEntity.ok().body("OK");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuario){
        return ResponseEntity.ok().body("OK");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@NotBlank @PathVariable("id") Long id){
        return ResponseEntity.ok().body("OK");
    }
}
