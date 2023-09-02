package com.fiap.grupo9.AppEletroControl.dominio.endereco.repository;

import com.fiap.grupo9.AppEletroControl.dominio.endereco.entitie.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnderecoRepository extends JpaRepository<Endereco, Long> {
    @Query(value = "select e.id, e.rua, e.cep, e.numero, e.cidade, " +
                    "e.bairro, e.uf, e.complemento " +
                    "from tb_endereco e " +
                    "where (:id is null or e.id = :id)" +
                    "and (:rua is null or e.rua = :rua)" +
                    "and (:cep is null or e.cep = :cep)" +
                    "and (:numero is null or e.numero = :numero)" +
                    "and (:cidade is null or e.cidade = :cidade)" +
                    "and (:bairro is null or e.bairro = :bairro)" +
                    "and (:uf is null or e.uf = :uf)" +
                    "and (:complemento is null or e.complemento = :complemento)"
    , nativeQuery = true
    ,countQuery = "select count(1) " +
                    "from tb_endereco e " +
                    "where (:id is null or e.id = :id)" +
                    "and (:rua is null or e.rua = :rua)" +
                    "and (:cep is null or e.cep = :cep)" +
                    "and (:numero is null or e.numero = :numero)" +
                    "and (:cidade is null or e.cidade = :cidade)" +
                    "and (:bairro is null or e.bairro = :bairro)" +
                    "and (:uf is null or e.uf = :uf)" +
                    "and (:complemento is null or e.complemento = :complemento)"
    )
    Page<Endereco> findByDTO(
            Pageable pageable,
            @Param("rua") String rua,
            @Param("id") Long id,
            @Param("cep") String cep,
            @Param("numero") Integer numero,
            @Param("cidade") String cidade,
            @Param("bairro") String bairro,
            @Param("uf") String uf,
            @Param("complemento") String complemento
            );
}
