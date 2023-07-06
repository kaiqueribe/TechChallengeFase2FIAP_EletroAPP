package com.fiap.grupo9.AppEletroControl.dominio.pessoa.controller;


import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.entitie.Eletrodomestico;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.entitie.Pessoa;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.service.PessoaService;
import com.fiap.grupo9.AppEletroControl.dominio.pessoa.dto.PessoaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

//    private final Validator validator;
//    private final ModelMapper modelMapper;

    @Autowired
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
    public ResponseEntity<PessoaDTO> buscarPorId(@PathVariable UUID id) {

        var pessoa = pessoaService.buscarPorId((id));
        return ResponseEntity.ok(pessoa);
    }


    @PostMapping
    public ResponseEntity<PessoaDTO> salvar(@RequestBody PessoaDTO pessoa) {
        var pessoaCadastrada = pessoaService.cadastrar(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((pessoaCadastrada.getId())).toUri();
        return ResponseEntity.created(uri).body(pessoaCadastrada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa, @PathVariable UUID id) {
        var pessoaAtualizada = pessoaService.atualizar(id, pessoa);
        return ResponseEntity.ok(pessoaAtualizada);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable UUID id){
        pessoaService.remover(id);
        return ResponseEntity.noContent().build();
    }


}
