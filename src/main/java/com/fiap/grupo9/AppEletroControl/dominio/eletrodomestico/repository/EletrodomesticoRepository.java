package com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.repository;

import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.entitie.Eletrodomestico;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.LongStream;

@Repository
public class EletrodomesticoRepository implements IEletrodomesticoRepository {

    private static Set<Eletrodomestico> eletrodomesticos;

    static {
        eletrodomesticos = new LinkedHashSet<>();

        Eletrodomestico eletrodomestico1 = new Eletrodomestico("Televisao", "Samsung 2np", 130.0, 110);
        Eletrodomestico eletrodomestico2 = new Eletrodomestico("Geladeira", "Eletrolux", 130.0, 110);

        eletrodomesticos.add(eletrodomestico1);
        eletrodomesticos.add(eletrodomestico2);

    }

    @Override
    public Set<Eletrodomestico> buscarTodos() {
        return eletrodomesticos;
    }

    @Override
    public Optional<Eletrodomestico> buscarPorId(LongStream id) {
        return eletrodomesticos.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    @Override
    public Eletrodomestico cadastrar(Eletrodomestico eletrodomestico) {
        eletrodomesticos.add(eletrodomestico);
        return eletrodomestico;
    }

    @Override
    public Eletrodomestico atualizar(LongStream id, Eletrodomestico eletrodomestico) {
       var eletrodomesticoBuscado = eletrodomesticos.stream().filter(e ->e.getId().equals(id)).findFirst().get();
        eletrodomesticoBuscado.setNome(eletrodomestico.getNome());
        eletrodomesticoBuscado.setModelo(eletrodomestico.getModelo());
        eletrodomesticoBuscado.setPotencia(eletrodomestico.getPotencia());
        eletrodomesticoBuscado.setVoltagem(eletrodomestico.getVoltagem());
        return eletrodomesticoBuscado;
    }

    @Override
    public void remover(LongStream id) {
        eletrodomesticos.removeIf(eletrodomestico -> eletrodomestico.getId().equals(id));

    }
}
