package br.com.ifg.controlefinanca.controllers.receita;

import br.com.ifg.controlefinanca.models.receita.dto.ReceitaDTO;
import br.com.ifg.controlefinanca.models.receita.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("receitas")
public class ReceitaController {
    @Autowired
    private ReceitaService service;

    @GetMapping
    public ResponseEntity<List<ReceitaDTO>> findAll(){
        List<ReceitaDTO> receitas = service.findAll();
        return !receitas.isEmpty() ?  ResponseEntity.ok(receitas) : ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ReceitaDTO>> findById(@NotBlank @PathVariable("id") Long id) throws IllegalAccessException {
        Optional<ReceitaDTO> receita = service.findById(id);
        return !receita.isEmpty() ? ResponseEntity.ok(receita) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<ReceitaDTO> create(@Valid @RequestBody ReceitaDTO receita){
        ReceitaDTO receitaCriada = service.create(receita);
        return ResponseEntity.status(HttpStatus.CREATED).body(receitaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceitaDTO> update(@PathVariable Long id, @Valid @RequestBody ReceitaDTO receita) throws IllegalAccessException {
        ReceitaDTO receitaAtualizada = service.update(id, receita);
        return ResponseEntity.ok().body(receitaAtualizada);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@NotBlank @PathVariable("id") Long id) throws IllegalAccessException {
        service.delete(id);
    }
}
