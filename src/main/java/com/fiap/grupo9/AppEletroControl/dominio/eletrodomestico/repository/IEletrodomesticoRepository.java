package com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.repository;

import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.entitie.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IEletrodomesticoRepository extends JpaRepository<Eletrodomestico, UUID> {

}
