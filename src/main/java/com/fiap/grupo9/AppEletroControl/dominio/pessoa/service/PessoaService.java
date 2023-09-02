package com.fiap.grupo9.AppEletroControl.dominio.pessoa.service;

import com.fiap.grupo9.AppEletroControl.config.service.exception.ControllerNotFoundException;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.dto.PessoaDTO;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.dto.PessoaDTOFilter;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.entitie.Pessoa;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.mapper.PessoaMapper;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.repository.IPessoaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class PessoaService {

    private IPessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public Page<PessoaDTO> buscarComFiltro(PageRequest pagina, PessoaDTOFilter filtro) {
        log.info("Buscando pessoas com filtro...");

        //apanhei aqui. passando direto filtro.getSexo() no findByDto, não entendia que era null
        String sexo = null;
        if (filtro.getSexo() != null){
            sexo = String.valueOf(filtro.getSexo());
        }
        var pessoas = pessoaRepository.findByDTO(pagina, filtro.getId(), filtro.getNome(), filtro.getDataNascimento(),
                filtro.getCpf(), sexo, filtro.getEmail(), filtro.getTelefone()
                , filtro.getParentesco(), filtro.getEnderecoId());
        return pessoas.map(pessoaMapper::toDTO);
    }

    public PessoaDTO buscarPorId(Long id) {
        log.info("Buscando pessoa com id {}...", id);
        var pessoa = pessoaRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Pessoa Não Encontrada"));
        return pessoaMapper.toDTO(pessoa);
    }

    public PessoaDTO cadastrarPessoa(PessoaDTO pessoaDTO) {
        log.info("Cadastrando pessoa {}...", pessoaDTO);
        final Pessoa pessoaCadastrada = pessoaRepository.save(
                pessoaMapper.toEntity(pessoaDTO)
        );

        return pessoaMapper.toDTO(pessoaCadastrada);
    }

    public PessoaDTO atualizar(Long id, PessoaDTO pessoaDTO) {
        Optional<Pessoa> pessoaOpt = pessoaRepository.findById(id);
        if (pessoaOpt.isPresent()) {
            Pessoa pessoa = pessoaOpt.get();

            pessoa.setNome(pessoaDTO.getNome());
            pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
            pessoa.setCpf(pessoaDTO.getCpf());

            pessoa = pessoaRepository.save(pessoa);

            return pessoaMapper.toDTO(pessoa);
        }

        return new PessoaDTO();
    }

    public void remover(Long id) {
        pessoaRepository.deleteById(id);
    }

}
