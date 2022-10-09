package br.com.ifg.controlefinanca.controllers.usuario;

import br.com.ifg.controlefinanca.models.usuario.dto.UsuarioDTO;
import br.com.ifg.controlefinanca.models.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


//TODO: Avaliando necessidade de haver EndPoints para Usuário.
@Deprecated
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
    public ResponseEntity<String> create(@Valid @RequestBody UsuarioDTO usuario){
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
