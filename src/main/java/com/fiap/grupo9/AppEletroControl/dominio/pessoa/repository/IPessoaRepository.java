package com.fiap.grupo9.AppEletroControl.dominio.pessoa.repository;

import com.fiap.grupo9.AppEletroControl.dominio.pessoa.entitie.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IPessoaRepository extends JpaRepository <Pessoa, Long> {
    @Query(value = "select e.id, e.nome, e.data_nascimento, e.cpf, e.sexo, " +
                "e.email, e.telefone, e.parentesco, e.endereco_id " +
                "from tb_pessoa e " +
                "where (:id is null or e.id = :id)" +
                "and (:nome is null or e.nome = :nome)" +
                "and (:data_nascimento is null or e.data_nascimento = :data_nascimento)" +
                "and (:cpf is null or e.cpf = :cpf)" +
                "and (:sexo is null or e.sexo = :sexo)" +
                "and (:email is null or e.email = :email)" +
                "and (:telefone is null or e.telefone = :telefone)" +
                "and (:parentesco is null or e.parentesco = :parentesco)" +
                "and (:endereco_id is null or e.endereco_id = :endereco_id)"
            ,nativeQuery = true
            ,countQuery = "select count(1) " +
                "from tb_pessoa e " +
                "where (:id is null or e.id = :id)" +
                "and (:nome is null or e.nome = :nome)" +
                "and (:data_nascimento is null or e.data_nascimento = :data_nascimento)" +
                "and (:cpf is null or e.cpf = :cpf)" +
                "and (:sexo is null or e.sexo = :sexo)" +
                "and (:email is null or e.email = :email)" +
                "and (:telefone is null or e.telefone = :telefone)" +
                "and (:parentesco is null or e.parentesco = :parentesco)" +
                "and (:endereco_id is null or e.endereco_id = :endereco_id)"
    )
    Page<Pessoa> findByDTO(
            Pageable pageable,
            @Param("id") Long id,
            @Param("nome") String nome,
            @Param("data_nascimento") LocalDate data_nascimento,
            @Param("cpf") String cpf,
            @Param("sexo") String sexo,
            @Param("email") String email,
            @Param("telefone") String telefone,
            @Param("parentesco") String parentesco,
            @Param("endereco_id") Long endereco_id
    );
}