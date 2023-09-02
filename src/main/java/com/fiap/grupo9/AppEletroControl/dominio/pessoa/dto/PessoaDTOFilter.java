package com.fiap.grupo9.AppEletroControl.dominio.pessoa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.enums.Sexo;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PessoaDTOFilter {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private Sexo sexo;
    private String email;
    private String telefone;
    private String parentesco;
    private Long enderecoId;

}
