package com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class EletrodomesticoDTOFilter {

    private Long id;
    private String nome;
    private String modelo;
    private Double potencia;
    private Double voltagem;
    @JsonIgnore
    private Long usuario;
}
