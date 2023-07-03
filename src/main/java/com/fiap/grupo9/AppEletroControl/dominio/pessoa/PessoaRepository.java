package com.fiap.grupo9.AppEletroControl.dominio.pessoa;


import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class PessoaRepository {
    static private Set<Pessoa> pessoas;

    static {

        pessoas = new LinkedHashSet<>();

    }


    public Collection<Pessoa> bucarTodos() {
        return pessoas;
    }

    public Optional<Pessoa> bucarPorId(Long id) {
        return pessoas.stream().filter(pessoa -> pessoa.getId().equals(id)).findFirst();
    }


    public static Pessoa cadastrar(Pessoa pessoa) {
        pessoa.setId(pessoas.size() + 1L);
        pessoas.add(pessoa);
        return pessoa;
    }

    public Optional<Pessoa> atualizar(Pessoa pessoa) {
        Optional<Pessoa> pessoaBuscada = this.bucarPorId(pessoa.getId());

        if (pessoaBuscada.isPresent()) {
            Pessoa pessoaEncontrada = pessoaBuscada.get();
            pessoaEncontrada.setNome(pessoa.getNome());
            pessoaEncontrada.setEmail(pessoa.getEmail());
            pessoaEncontrada.setTelefone(pessoa.getTelefone());
            pessoaEncontrada.setTelefone(pessoa.getTelefone());
            pessoaEncontrada.setEndereco(pessoa.getEndereco());

            return Optional.of(pessoa);
        }
        return Optional.empty();
    }

    public void remover (Long id){
        pessoas.removeIf(pessoa -> pessoa.getId().equals(id));
    }



}
