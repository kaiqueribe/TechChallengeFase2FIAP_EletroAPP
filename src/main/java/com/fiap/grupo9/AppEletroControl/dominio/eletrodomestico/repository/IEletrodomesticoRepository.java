package com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.repository;

import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.entitie.Eletrodomestico;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.LongStream;

public interface IEletrodomesticoRepository {

    Set<Eletrodomestico> buscarTodos();

    Optional<Eletrodomestico> buscarPorId(UUID id);

    Eletrodomestico cadastrar (Eletrodomestico eletrodomestico);

    Eletrodomestico atualizar(UUID id,Eletrodomestico eletrodomestico);

    void remover (UUID id);
}
