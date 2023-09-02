package com.fiap.grupo9.AppEletroControl.dominio.usuario.entitie;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_usuario")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
