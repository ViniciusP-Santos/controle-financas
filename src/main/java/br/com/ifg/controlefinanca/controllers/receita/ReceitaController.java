package br.com.ifg.controlefinanca.controllers.receita;

import br.com.ifg.controlefinanca.models.receita.dto.ReceitaDTO;
import br.com.ifg.controlefinanca.models.receita.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("receitas")
public class ReceitaController {
    @Autowired
    private ReceitaService service;

    @GetMapping
    public ResponseEntity<String> findAll(){
        return ResponseEntity.ok().body("OK");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@NotBlank @PathVariable("id") Long id){
        return ResponseEntity.ok().body("OK");
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> create(@PathVariable Long id, @Valid @RequestBody ReceitaDTO receita){
        return ResponseEntity.ok().body("OK");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody ReceitaDTO receita){
        return ResponseEntity.ok().body("OK");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@NotBlank @PathVariable("id") Long id){
        return ResponseEntity.ok().body("OK");
    }
}
