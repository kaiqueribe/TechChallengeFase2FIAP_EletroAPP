package com.fiap.grupo9.AppEletroControl.dominio.endereco.entitie;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;
@Entity
@Table(name = "tb_endereco")

public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String cep;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String complemento;

    public UUID getId() {
        return id;
    }

    public Endereco setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public Endereco setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public Endereco setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Endereco setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public Endereco setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public Endereco setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getUf() {
        return uf;
    }

    public Endereco setUf(String uf) {
        this.uf = uf;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public Endereco setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(getId(), endereco.getId()) && Objects.equals(getCep(), endereco.getCep()) && Objects.equals(getNumero(), endereco.getNumero()) && Objects.equals(getComplemento(), endereco.getComplemento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCep(), getNumero(), getComplemento());
    }
}
