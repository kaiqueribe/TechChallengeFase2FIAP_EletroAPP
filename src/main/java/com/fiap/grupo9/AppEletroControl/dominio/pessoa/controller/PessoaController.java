package com.fiap.grupo9.AppEletroControl.dominio.pessoa.controller;

import com.fiap.grupo9.AppEletroControl.dominio.pessoa.service.PessoaService;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.dto.PessoaDTO;
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

    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<Page<PessoaDTO>> buscarTodos(
            @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(value = "tamanho", defaultValue = "10") Integer tamanho
    ) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);

        var pessoas = pessoaService.buscarTodos(pageRequest);
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> buscarPorId(@PathVariable Long id) {
        var pessoa = pessoaService.buscarPorId((id));
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> salvar(@RequestBody PessoaDTO pessoa) {
        var pessoaCadastrada = pessoaService.cadastrarPessoa(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((pessoaCadastrada.getId())).toUri();
        return ResponseEntity.created(uri).body(pessoaCadastrada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTO> atualizar(@RequestBody PessoaDTO pessoaDTO, @PathVariable Long id) {
        var pessoaAtualizada = pessoaService.atualizar(id, pessoaDTO);
        return ResponseEntity.ok(pessoaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        pessoaService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
