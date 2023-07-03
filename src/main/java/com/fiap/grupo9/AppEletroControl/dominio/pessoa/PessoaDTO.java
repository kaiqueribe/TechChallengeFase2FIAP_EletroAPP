package com.fiap.grupo9.AppEletroControl.dominio.pessoa;

import com.fiap.grupo9.AppEletroControl.dominio.endereco.EnderecoDTO;

import java.time.LocalDate;

public record PessoaDTO(String nome, String email, String telefone, LocalDate dataNascimento/*,
                        NivelUsuario nivelUsuario, GrauFamiliar grauFamiliar*/, EnderecoDTO endereco) {
}
