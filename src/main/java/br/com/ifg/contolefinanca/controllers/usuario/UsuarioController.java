package br.com.ifg.contolefinanca.controllers.usuario;

import br.com.ifg.contolefinanca.models.usuario.dto.UsuarioDTO;
import br.com.ifg.contolefinanca.models.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/{id}")
    public ResponseEntity<String> create(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuario){
        return ResponseEntity.ok().body("OK");
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
