package com.fiap.grupo9.AppEletroControl.dominio.endereco.service;

import com.fiap.grupo9.AppEletroControl.config.service.exception.ControllerNotFoundException;
import com.fiap.grupo9.AppEletroControl.dominio.endereco.dto.EnderecoDTO;
import com.fiap.grupo9.AppEletroControl.dominio.endereco.dto.EnderecoDTOFilter;
import com.fiap.grupo9.AppEletroControl.dominio.endereco.entitie.Endereco;
import com.fiap.grupo9.AppEletroControl.dominio.endereco.mapper.EnderecoMapper;
import com.fiap.grupo9.AppEletroControl.dominio.endereco.repository.IEnderecoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class EnderecoService {

    private final IEnderecoRepository repository;
    private final EnderecoMapper enderecoMapper;

    public Page<EnderecoDTO> buscarComFiltro(PageRequest pagina, EnderecoDTOFilter filtro) {
        log.info("Buscando endereços com filtros...");
        var enderecos = repository.findByDTO(pagina,filtro.getRua(), filtro.getId(), filtro.getCep(),
                filtro.getNumero(), filtro.getCidade(),filtro.getBairro(), filtro.getUf(), filtro.getComplemento());
        return enderecos.map(enderecoMapper::toDTO);
    }

    public EnderecoDTO buscarPorId(Long id) {
        log.info("Buscando endereço com id {}...", id);
        var endereco = repository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Endereço Não Encontrado"));
        return enderecoMapper.toDTO(endereco);
    }

    public EnderecoDTO cadastrar(EnderecoDTO enderecoDTO) {
        log.info("Cadastrando endereço {}...", enderecoDTO);
        Endereco entidade = enderecoMapper.toEntity(enderecoDTO);
        var enderecoCadastrado = repository.save(entidade);
        return enderecoMapper.toDTO(enderecoCadastrado);
    }

    public Endereco atualizar(Long id, Endereco endereco) {

        Endereco buscaEndereco = (Endereco) repository.getOne(id);
        buscaEndereco.setCep(endereco.getCep());
        buscaEndereco.setNumero(endereco.getNumero());
        buscaEndereco.setBairro(endereco.getBairro());
        buscaEndereco.setCidade(endereco.getCidade());
        buscaEndereco.setUf(endereco.getUf());
        buscaEndereco.setComplemento(endereco.getComplemento());
        buscaEndereco.setRua(endereco.getRua());

        buscaEndereco = repository.save(buscaEndereco);

        return buscaEndereco;
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}
