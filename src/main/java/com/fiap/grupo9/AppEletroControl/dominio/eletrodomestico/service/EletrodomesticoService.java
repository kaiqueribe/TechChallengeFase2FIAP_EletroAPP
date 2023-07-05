package com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.service;

import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.dto.EletrodomesticoDTO;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.entitie.Eletrodomestico;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.repository.IEletrodomesticoRepository;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.service.exception.ControllerNotFoundException;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.service.exception.DatabaseException;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.EmptyStackException;
import java.util.UUID;


@Service
public class EletrodomesticoService {


    @Autowired
    private IEletrodomesticoRepository repository;


    public Page<EletrodomesticoDTO> buscarTodos(PageRequest pagina) {

        var eletrodomesticos = repository.findAll(pagina);

        return eletrodomesticos.map(eletrodomestico -> new EletrodomesticoDTO(eletrodomestico));
    }

    public EletrodomesticoDTO buscarPorId(UUID id) {

        var eletrodomestico = repository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Eletrodoméstico não encontrado"));
        return new EletrodomesticoDTO(eletrodomestico);

    }

    public EletrodomesticoDTO cadastrar(EletrodomesticoDTO eletrodomestico) {
        Eletrodomestico entidade = new Eletrodomestico();
        entidade.setNome(eletrodomestico.getNome());
        entidade.setModelo(eletrodomestico.getModelo());
        entidade.setPotencia(eletrodomestico.getPotencia());
        entidade.setVoltagem(eletrodomestico.getVoltagem());

        var eletrodomesticoCadastrado = repository.save(entidade);
        return new EletrodomesticoDTO(eletrodomesticoCadastrado);
    }

    public Eletrodomestico atualizar(UUID id, Eletrodomestico eletrodomestico) {
        try {
            Eletrodomestico buscaEletrodomestico = repository.getOne(id);
            buscaEletrodomestico.setNome(eletrodomestico.getNome());
            buscaEletrodomestico.setModelo(eletrodomestico.getModelo());
            buscaEletrodomestico.setPotencia(eletrodomestico.getPotencia());
            buscaEletrodomestico.setVoltagem(eletrodomestico.getVoltagem());
            buscaEletrodomestico = repository.save(buscaEletrodomestico);

            return buscaEletrodomestico;
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Eletrodoméstico não encontrado, id:" + id);

        }


    }

    public void remover(UUID id) {

        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Eletrodoméstico não encontrado, " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade da base");
        }
//        } catch (NoContentException e) {
//            throw new EntityNotFoundException("Eletrodoméstico não encontrado, " + id);
//        }


    }
}