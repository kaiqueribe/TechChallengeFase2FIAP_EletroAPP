package com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.dto;

import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.entitie.Eletrodomestico;

import java.util.UUID;

public class EletrodomesticoDTO {

    private UUID id;
    private String nome;
    private String modelo;
    private double potencia;
    private double voltagem;

    public EletrodomesticoDTO() {
    }

    public EletrodomesticoDTO(UUID id, String nome, String modelo, double potencia, double voltagem) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
        this.potencia = potencia;
        this.voltagem = voltagem;
    }

    public EletrodomesticoDTO(Eletrodomestico entidade){
        this.id = entidade.getId();
        this.nome=entidade.getNome();
        this.modelo=entidade.getModelo();
        this.potencia=entidade.getPotencia();
        this.voltagem=entidade.getVoltagem();
    }

    public UUID getId() {
        return id;
    }

    public EletrodomesticoDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public EletrodomesticoDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public EletrodomesticoDTO setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public double getPotencia() {
        return potencia;
    }

    public EletrodomesticoDTO setPotencia(double potencia) {
        this.potencia = potencia;
        return this;
    }

    public double getVoltagem() {
        return voltagem;
    }

    public EletrodomesticoDTO setVoltagem(double voltagem) {
        this.voltagem = voltagem;
        return this;
    }
}
