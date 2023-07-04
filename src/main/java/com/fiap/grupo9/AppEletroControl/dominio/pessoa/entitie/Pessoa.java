package com.fiap.grupo9.AppEletroControl.dominio.pessoa.entitie;

import com.fiap.grupo9.AppEletroControl.dominio.endereco.Endereco;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.dto.PessoaDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    //    @Enumerated(EnumType.STRING)
//    private Enum nivelUsuario;
//    @Enumerated(EnumType.STRING)
//    private Enum grauFamiliar;
    @Embedded
    private Endereco endereco;


    public Pessoa(PessoaDTO dados) {

        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.dataNascimento = dados.dataNascimento();
//        this.nivelUsuario = dados.nivelUsuario();
//        this.grauFamiliar = dados.grauFamiliar();
        this.endereco = new Endereco(dados.endereco());
    }
}

