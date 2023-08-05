package com.fiap.grupo9.AppEletroControl.dominio.endereco.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoDTO{

    @JsonIgnore // Ignorar o campo "id" na serialização no método POST
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String rua;

    @JsonProperty
    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "CEP inválido")
    private String cep;

    @JsonProperty
    @Range(min = 0, max = 10000)
    private Integer numero;

    @NotBlank
    @Size(max = 100)
    private String cidade;

    @JsonProperty
    @NotBlank
    private String bairro;

    @JsonProperty
    @NotBlank
    @Size(max = 2)
    private String uf;

    @JsonProperty
    private String complemento;
}
