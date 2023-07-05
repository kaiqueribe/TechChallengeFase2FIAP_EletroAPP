package com.fiap.grupo9.AppEletroControl.dominio.pessoa.repository;

import com.fiap.grupo9.AppEletroControl.dominio.pessoa.entitie.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPessoaRepository extends JpaRepository <Pessoa, UUID> {


}
