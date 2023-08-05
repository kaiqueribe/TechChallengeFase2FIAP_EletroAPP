package com.fiap.grupo9.AppEletroControl.dominio.endereco.mapper;

import com.fiap.grupo9.AppEletroControl.dominio.endereco.dto.EnderecoDTO;
import com.fiap.grupo9.AppEletroControl.dominio.endereco.entitie.Endereco;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EnderecoMapper {
    EnderecoDTO toDTO(Endereco endereco);
    Endereco toEntity(EnderecoDTO pessoaDTO);
    List<EnderecoDTO> toDTO(List<Endereco> enderecos);
}
