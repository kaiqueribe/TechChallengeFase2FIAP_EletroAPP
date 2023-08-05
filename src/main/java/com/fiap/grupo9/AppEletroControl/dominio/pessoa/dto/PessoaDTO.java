package com.fiap.grupo9.AppEletroControl.dominio.pessoa.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.enums.Sexo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PessoaDTO {
    @JsonIgnore // Ignorar o campo "id" na serialização no método POST
    private Long id;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @Size(min = 2, max = 50)
    private String nome;

    @Past
    private LocalDate dataNascimento;

    @CPF
    private String cpf;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4}-\\d{4}", message = "Número de telefone inválido")
    private String telefone;

    private String parentesco;

    @NotNull
    private Long enderecoId;

    @JsonProperty // Incluir o campo "id" na serialização no método GET
    public Long getId() {
        return id;
    }

}
