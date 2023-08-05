package com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class EletrodomesticoDTO {

    private Long id;
    private String nome;
    private String modelo;
    private double potencia;
    private double voltagem;
}
