package com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.entitie;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_eletrodomestico")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Eletrodomestico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String modelo;
    private Double potencia;
    private Double voltagem;
}
