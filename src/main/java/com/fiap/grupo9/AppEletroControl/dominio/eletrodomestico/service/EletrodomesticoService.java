package com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.service;

import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.entitie.Eletrodomestico;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.repository.IEletrodomesticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.LongStream;

@Service
public class EletrodomesticoService {

    @Qualifier("eletrodomesticoRepository")
    @Autowired
    private IEletrodomesticoRepository repository;


    public Collection<Eletrodomestico> buscarTodos() {
        var eletrodomesticos = repository.buscarTodos();
        return eletrodomesticos;
    }

    public Optional<Eletrodomestico> buscarPorId(UUID id) {
        var eletrodomesticos = repository.buscarPorId(id);
        return eletrodomesticos;
    }

    public Eletrodomestico cadastrar(Eletrodomestico eletrodomestico) {
        var produtoSalvo = repository.cadastrar(eletrodomestico);
        return produtoSalvo;
    }

    public Optional<Eletrodomestico> atualizar(UUID id, Eletrodomestico eletrodomestico) {
        Optional<Eletrodomestico> eletrodomesticoBuscado = this.buscarPorId(id);

        if (eletrodomesticoBuscado.isPresent()) {
            Eletrodomestico eletrodomesticoAtualizado = repository.atualizar(id, eletrodomestico);
            return Optional.of(eletrodomesticoAtualizado);
        }
        return Optional.empty();
    }

    public void remover(UUID id){
        repository.remover(id);
    }


}
