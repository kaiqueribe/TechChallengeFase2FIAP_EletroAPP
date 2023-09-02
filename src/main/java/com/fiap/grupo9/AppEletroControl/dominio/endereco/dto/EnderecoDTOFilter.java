package com.fiap.grupo9.AppEletroControl.dominio.endereco.dto;

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
public class EnderecoDTOFilter {

    private Long id;
    private String rua;
    private String cep;
    private Integer numero;
    private String cidade;
    private String bairro;
    private String uf;
    private String complemento;
}
