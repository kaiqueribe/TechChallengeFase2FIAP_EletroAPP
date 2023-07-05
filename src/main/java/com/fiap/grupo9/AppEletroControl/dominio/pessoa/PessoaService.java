package com.fiap.grupo9.AppEletroControl.dominio.pessoa;


import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.service.exception.ControllerNotFoundException;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.dto.PessoaDTO;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.repository.IPessoaRepository;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.entitie.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PessoaService {

    @Autowired
    private IPessoaRepository repository;

    public Page<PessoaDTO> buscarTodos(PageRequest pagina) {
        var pessoas = repository.findAll(pagina);
        return pessoas.map(pessoa -> new PessoaDTO(pessoa));

    }


    public PessoaDTO buscarPorId(UUID id) {

        var pessoa = repository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Pessoa Não Encontrada"));
        return new PessoaDTO(pessoa);

    }

    public PessoaDTO cadastrar(PessoaDTO pessoa) {
        Pessoa entidade = new Pessoa();
        entidade.setNome(pessoa.getNome());
        entidade.setDataNascimento(pessoa.getDataNascimento());
        entidade.setCpf(pessoa.getCpf());

        var pessoaCadastrada = repository.save(entidade);
        return new PessoaDTO(pessoaCadastrada);
    }

    public Pessoa atualizar(UUID id, Pessoa pessoa) {

        Pessoa buscaPessoa = (Pessoa) repository.getOne(id);
        buscaPessoa.setNome(pessoa.getNome());
        buscaPessoa.setDataNascimento(pessoa.getDataNascimento());
        buscaPessoa.setCpf(pessoa.getCpf());

        buscaPessoa = repository.save(buscaPessoa);

        return buscaPessoa;


    }

    public void remover(UUID id) {

        repository.deleteById(id);


    }

}
