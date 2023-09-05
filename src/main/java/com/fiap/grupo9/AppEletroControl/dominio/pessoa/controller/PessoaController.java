package com.fiap.grupo9.AppEletroControl.dominio.pessoa.controller;

import com.fiap.grupo9.AppEletroControl.dominio.pessoa.dto.PessoaDTOFilter;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.service.PessoaService;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.dto.PessoaDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pessoas")
@AllArgsConstructor
public class PessoaController {
    private static final String requestReader = "usuario-auth-key";
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<Page<PessoaDTO>> buscarComFiltro(
            @RequestHeader(requestReader) Long usuarioId,
            @Valid @ModelAttribute PessoaDTOFilter filtro,
            @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(value = "tamanho", defaultValue = "10") Integer tamanho
    ) {
        filtro.setUsuario(usuarioId);
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);
        var pessoas = pessoaService.buscarComFiltro(pageRequest, filtro);
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> buscarPorId(
            @RequestHeader(requestReader) Long usuarioId,
            @PathVariable Long id
    ) {
        var pessoa = pessoaService.buscarPorId((id));
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> salvar(
            @RequestHeader(requestReader) Long usuarioId,
            @RequestBody PessoaDTO pessoa
    ) {
        pessoa.setUsuario(usuarioId);
        var pessoaCadastrada = pessoaService.cadastrarPessoa(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((pessoaCadastrada.getId())).toUri();
        return ResponseEntity.created(uri).body(pessoaCadastrada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTO> atualizar(
            @RequestHeader(requestReader) Long usuarioId,
            @RequestBody PessoaDTO pessoaDTO,
            @PathVariable Long id
    ) {
        var pessoaAtualizada = pessoaService.atualizar(id, pessoaDTO);
        return ResponseEntity.ok(pessoaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(
            @RequestHeader(requestReader) Long usuarioId,
            @PathVariable Long id
    ){
        pessoaService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
