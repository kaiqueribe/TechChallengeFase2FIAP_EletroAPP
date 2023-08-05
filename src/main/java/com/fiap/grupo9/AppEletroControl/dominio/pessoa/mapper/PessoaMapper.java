package com.fiap.grupo9.AppEletroControl.dominio.pessoa.mapper;

import com.fiap.grupo9.AppEletroControl.dominio.endereco.entitie.Endereco;
import com.fiap.grupo9.AppEletroControl.dominio.endereco.repository.IEnderecoRepository;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.dto.PessoaDTO;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.entitie.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public abstract class PessoaMapper {

    @Autowired
    private IEnderecoRepository enderecoRepository;

    @Mapping(target = "enderecoId", source = "endereco.id")
    public abstract PessoaDTO toDTO(Pessoa pessoa);

    @Mapping(target = "endereco", expression = "java(getEndereco(pessoaDTO.getEnderecoId()))")
    public abstract Pessoa toEntity(PessoaDTO pessoaDTO);

    public abstract List<PessoaDTO> toDTO(List<Pessoa> pessoas);

    protected Endereco getEndereco(Long enderecoId) {
        if (enderecoId != null) {
            return enderecoRepository.findById(enderecoId).orElse(null);
        }
        return null;
    }
}
