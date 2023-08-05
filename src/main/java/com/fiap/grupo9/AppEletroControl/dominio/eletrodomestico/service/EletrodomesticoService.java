package com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.service;

import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.dto.EletrodomesticoDTO;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.entitie.Eletrodomestico;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.mapper.EletrodomesticoMapper;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.repository.IEletrodomesticoRepository;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.service.exception.ControllerNotFoundException;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.service.exception.DatabaseException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class EletrodomesticoService {
    private IEletrodomesticoRepository repository;
    private EletrodomesticoMapper eletrodomesticoMapper;

    public Page<EletrodomesticoDTO> buscarTodos(PageRequest pagina) {
        log.info("Buscando todos os eletrodomésticos...");
        var eletrodomesticos = repository.findAll(pagina);
        return eletrodomesticos.map(eletrodomesticoMapper::toDTO);
    }

    public EletrodomesticoDTO buscarPorId(Long id) {
        log.info("Buscando eletrodoméstico com id {}...", id);
        var eletrodomestico = repository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Eletrodoméstico não encontrado"));
        return eletrodomesticoMapper.toDTO(eletrodomestico);
    }

    public EletrodomesticoDTO cadastrar(EletrodomesticoDTO eletrodomesticoDTO) {
        log.info("Cadastrando eletrodoméstico {}...", eletrodomesticoDTO);
        Eletrodomestico eletrodomestico = eletrodomesticoMapper.toEntity(eletrodomesticoDTO);
        var eletrodomesticoCadastrado = repository.save(eletrodomestico);
        return eletrodomesticoMapper.toDTO(eletrodomesticoCadastrado);
    }

    public Eletrodomestico atualizar(Long id, EletrodomesticoDTO eletrodomesticoDTO) {
        try {
            Eletrodomestico buscaEletrodomestico = repository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Eletrodoméstico não encontrado"));
            buscaEletrodomestico.setNome(eletrodomesticoDTO.getNome());
            buscaEletrodomestico.setModelo(eletrodomesticoDTO.getModelo());
            buscaEletrodomestico.setPotencia(eletrodomesticoDTO.getPotencia());
            buscaEletrodomestico.setVoltagem(eletrodomesticoDTO.getVoltagem());
            buscaEletrodomestico = repository.save(buscaEletrodomestico);

            return buscaEletrodomestico;
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Eletrodoméstico não encontrado, id:" + id);
        }
    }

    public void remover(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Eletrodoméstico não encontrado, " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade da base");
        }
    }
}