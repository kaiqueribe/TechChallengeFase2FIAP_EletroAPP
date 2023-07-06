package com.fiap.grupo9.AppEletroControl.dominio.endereco.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.grupo9.AppEletroControl.dominio.endereco.entitie.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;


import java.util.UUID;
@Getter
@Setter
public class EnderecoDTO{


    private UUID id;
    @JsonProperty
    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "CEP inválido")
    private String cep;
    @JsonProperty
    @NotBlank
    private String endereco;
    @JsonProperty
    private String numero;
    @JsonProperty
    @NotBlank
    private String bairro;
    @JsonProperty
    @NotBlank
    private String uf;
    @JsonProperty
    private String complemento;

    public EnderecoDTO() {
    }

    public EnderecoDTO(UUID id, String cep, String endereco, String numero, String bairro, String uf, String complemento) {
        this.id = id;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.uf = uf;
        this.complemento = complemento;
    }

    public EnderecoDTO (Endereco entidade){
        this.id = entidade.getId();
        this.cep = entidade.getCep();
        this.endereco = entidade.getEndereco();
        this.numero=entidade.getNumero();
        this.bairro=entidade.getBairro();
        this.uf=entidade.getUf();
        this.complemento=entidade.getComplemento();
    }
}
