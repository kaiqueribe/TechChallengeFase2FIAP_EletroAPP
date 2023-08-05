package com.fiap.grupo9.AppEletroControl.dominio.pessoa.entitie;

import com.fiap.grupo9.AppEletroControl.dominio.endereco.entitie.Endereco;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.enums.Sexo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_pessoa")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    private String email;
    private String telefone;

    @OneToOne
    private Endereco endereco;
    private String parentesco;
}
