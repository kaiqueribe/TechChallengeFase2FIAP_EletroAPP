package com.fiap.grupo9.AppEletroControl.dominio.endereco.service;

import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.service.exception.ControllerNotFoundException;
import com.fiap.grupo9.AppEletroControl.dominio.endereco.dto.EnderecoDTO;
import com.fiap.grupo9.AppEletroControl.dominio.endereco.entitie.Endereco;
import com.fiap.grupo9.AppEletroControl.dominio.endereco.repository.IEnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class EnderecoService {

    @Autowired
    private IEnderecoRepository repository;

    public Page<EnderecoDTO> buscarTodos(PageRequest pagina) {
        var enderecos = repository.findAll(pagina);
        return enderecos.map(endereco -> new EnderecoDTO(endereco));
    }

    public EnderecoDTO buscarPorId(UUID id) {
        var endereco = repository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Endereço Não Encontrado"));
        return new EnderecoDTO(endereco);
    }

    public EnderecoDTO cadastrar(EnderecoDTO endereco) {
        Endereco entidade = new Endereco();
        entidade.setCep(endereco.getCep());
        entidade.setEndereco(endereco.getEnd());
        entidade.setNumero(endereco.getNumero());
        entidade.setBairro(endereco.getBairro());
        entidade.setUf(endereco.getUf());
        entidade.setComplemento(endereco.getComplemento());


        var enderecoCadastrado = repository.save(entidade);
        return new EnderecoDTO(enderecoCadastrado);
    }

    public Endereco atualizar(UUID id, Endereco endereco) {

        Endereco buscaEndereco = (Endereco) repository.getOne(id);
        buscaEndereco.setEndereco(endereco.getEndereco());
        buscaEndereco.setEndereco(endereco.getNumero());
        buscaEndereco.setBairro(endereco.getBairro());
        buscaEndereco.setCidade(endereco.getCidade());
        buscaEndereco.setUf(endereco.getUf());
        buscaEndereco.setComplemento(endereco.getComplemento());

        buscaEndereco = repository.save(buscaEndereco);

        return buscaEndereco;

    }

    public void remover(UUID id) {

        repository.deleteById(id);


    }


}
