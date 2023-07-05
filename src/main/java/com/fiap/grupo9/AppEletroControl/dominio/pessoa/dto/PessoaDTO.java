package com.fiap.grupo9.AppEletroControl.dominio.pessoa.dto;

import com.fiap.grupo9.AppEletroControl.dominio.pessoa.entitie.Pessoa;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class PessoaDTO {

    private UUID id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;

    public PessoaDTO() {
    }

    public PessoaDTO(UUID id, String nome, LocalDate dadaNascimento, String cpf) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dadaNascimento;
        this.cpf = cpf;
    }

    public PessoaDTO(Pessoa entidade){
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.dataNascimento= entidade.getDataNascimento();
        this.cpf = entidade.getCpf();
    }

    public UUID getId() {
        return id;
    }

    public PessoaDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public PessoaDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public PessoaDTO setDataNascimento(LocalDate dadaNascimento) {
        this.dataNascimento = dadaNascimento;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public PessoaDTO setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }
}
