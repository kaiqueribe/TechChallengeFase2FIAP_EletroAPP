package com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.entitie;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.LongStream;

public class Eletrodomestico {

    private LongStream id;
    private String nome;
    private String modelo;
    private double potencia;
    private double voltagem;
//    private double consumo;

//    LocalDateTime horarioConsumo;


    public Eletrodomestico() {
    }

    public Eletrodomestico( String nome, String modelo, double potencia, double voltagem) {
        this.id = LongStream.of();
        this.nome = nome;
        this.modelo = modelo;
        this.potencia = potencia;
        this.voltagem = voltagem;
//        this.consumo = consumo;
    }

    public LongStream getId() {
        return id;
    }

    public Eletrodomestico setId(LongStream id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Eletrodomestico setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public Eletrodomestico setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public double getPotencia() {
        return potencia;
    }

    public Eletrodomestico setPotencia(double potencia) {
        this.potencia = potencia;
        return this;
    }

    public double getVoltagem() {
        return voltagem;
    }

    public Eletrodomestico setVoltagem(double voltagem) {
        this.voltagem = voltagem;
        return this;
    }

//    public double getConsumo() {
//        return consumo;
//    }
//
//    public Eletrodomestico setConsumo(double consumo) {
//        this.consumo = consumo;
//        return this;
//    }

    @Override
    public String toString() {
        return "Eletrodomestico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", modelo='" + modelo + '\'' +
                ", potencia=" + potencia +
                ", voltagem=" + voltagem +
//                ", consumo=" + consumo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eletrodomestico that = (Eletrodomestico) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
