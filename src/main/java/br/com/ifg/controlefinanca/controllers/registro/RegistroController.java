package br.com.ifg.controlefinanca.controllers.registro;

import br.com.ifg.controlefinanca.models.registro.dto.RegistroRequestDTO;
import br.com.ifg.controlefinanca.models.registro.service.RegistroService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/registration")
public class RegistroController {
    @Autowired
    private RegistroService registroService;

    @PostMapping
    public String register(@Valid @RequestBody RegistroRequestDTO request){
        return registroService.register(request);
    }
    @GetMapping("confirm")
    public String confirm(@RequestParam("token") String token) {
        return registroService.confirmToken(token);
    }
}
