package br.com.ifg.controlefinanca.models.registro.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class RegistroRequestDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate nascimento;
    private String estado;
}
