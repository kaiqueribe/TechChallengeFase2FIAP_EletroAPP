package com.fiap.grupo9.AppEletroControl.dominio.pessoa.repository;

import com.fiap.grupo9.AppEletroControl.dominio.pessoa.entitie.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface IPessoaRepository extends JpaRepository <Pessoa, Long> {

}
