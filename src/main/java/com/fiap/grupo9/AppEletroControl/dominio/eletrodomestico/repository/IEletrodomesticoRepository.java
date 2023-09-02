package com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.repository;

import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.entitie.Eletrodomestico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IEletrodomesticoRepository extends JpaRepository<Eletrodomestico, Long> {
    @Query(value = "select e.id, e.nome, e.modelo, e.potencia, e.voltagem " +
                    "from tb_eletrodomestico e " +
                    "where (:nome is null or e.nome = :nome)" +
                    "and (:id is null or e.id = :id)" +
                    "and (:modelo is null or e.modelo = :modelo)" +
                    "and (:voltagem is null or e.voltagem = :voltagem)" +
                    "and (:potencia is null or e.potencia = :potencia)"
    ,nativeQuery = true
    ,countQuery = "select count(1) " +
                    "from tb_eletrodomestico e " +
                    "where (:nome is null or e.nome = :nome)" +
                    "and (:id is null or e.id = :id)" +
                    "and (:modelo is null or e.modelo = :modelo)" +
                    "and (:voltagem is null or e.voltagem = :voltagem)" +
                    "and (:potencia is null or e.potencia = :potencia)"
    )
    Page<Eletrodomestico> findByDTO(
            Pageable pageable,
            @Param("nome") String nome,
            @Param("id") Long id,
            @Param("modelo") String modelo,
            @Param("voltagem") Double voltagem,
            @Param("potencia") Double potencia
    );
}
