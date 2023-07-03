package com.fiap.grupo9.AppEletroControl.dominio.endereco;

public record EnderecoDTO(String cep, String logradouro, String bairro,
                          String cidade, String uf, String complemento,
                          String numero) {
}
