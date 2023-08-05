package com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.mapper;

import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.dto.EletrodomesticoDTO;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.entitie.Eletrodomestico;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EletrodomesticoMapper {
    EletrodomesticoDTO toDTO(Eletrodomestico eletrodomestico);
    Eletrodomestico toEntity(EletrodomesticoDTO eletrodomesticoDTO);
    List<EletrodomesticoDTO> toDTO(List<Eletrodomestico> eletrodomesticos);
}
