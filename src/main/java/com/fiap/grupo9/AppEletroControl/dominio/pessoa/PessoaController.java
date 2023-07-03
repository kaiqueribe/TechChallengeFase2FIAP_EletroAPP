package com.fiap.grupo9.AppEletroControl.dominio.pessoa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @GetMapping(value = {"/",""})
    public ResponseEntity<Collection<Pessoa>> buscarPessoas() {
        var pessoas = repository.bucarTodos();
        return ResponseEntity.ok(pessoas);

    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Pessoa>> buscarPorId(@PathVariable Long id) {
        var pessoa = this.repository.bucarPorId(id);
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa) {
        repository.cadastrar(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Optional<Pessoa>> editarPessoa(@RequestBody Pessoa pessoa) {
      Optional<Pessoa> pessoaEditada =  repository.atualizar(pessoa);
      return ResponseEntity.ok(pessoaEditada);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletarPessoa(@PathVariable Long id) {
        repository.remover(id);
        return ResponseEntity.ok("Pessoa Deletada com  Sucesso");
    }


}
