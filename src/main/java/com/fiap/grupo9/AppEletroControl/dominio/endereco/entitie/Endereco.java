package com.fiap.grupo9.AppEletroControl.dominio.endereco.entitie;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_endereco")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private String cep;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String complemento;
}
