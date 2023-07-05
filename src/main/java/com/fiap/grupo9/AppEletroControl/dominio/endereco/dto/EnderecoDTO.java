package com.fiap.grupo9.AppEletroControl.dominio.endereco.dto;

import com.fiap.grupo9.AppEletroControl.dominio.endereco.entitie.Endereco;


import java.util.UUID;

public class EnderecoDTO{


    private UUID id;
    private String cep;
    private String end;
    private String numero;

    private String bairro;
    private String uf;
    private String complemento;

    public EnderecoDTO() {
    }

    public EnderecoDTO(UUID id, String cep, String end, String numero, String bairro, String uf, String complemento) {
        this.id = id;
        this.cep = cep;
        this.end = end;
        this.numero = numero;
        this.bairro = bairro;
        this.uf = uf;
        this.complemento = complemento;
    }

    public EnderecoDTO (Endereco entidade){
        this.id = entidade.getId();
        this.cep = entidade.getCep();
        this.end= entidade.getEndereco();
        this.numero=entidade.getNumero();
        this.bairro=entidade.getBairro();
        this.uf=entidade.getUf();
        this.complemento=entidade.getComplemento();
    }

    public UUID getId() {
        return id;
    }

    public EnderecoDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public EnderecoDTO setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getEnd() {
        return end;
    }

    public EnderecoDTO setEnd(String end) {
        this.end = end;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public EnderecoDTO setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public EnderecoDTO setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getUf() {
        return uf;
    }

    public EnderecoDTO setUf(String uf) {
        this.uf = uf;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public EnderecoDTO setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }
}
