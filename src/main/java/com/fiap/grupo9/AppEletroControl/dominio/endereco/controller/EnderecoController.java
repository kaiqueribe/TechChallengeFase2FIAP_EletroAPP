package com.fiap.grupo9.AppEletroControl.dominio.endereco.controller;

import com.fiap.grupo9.AppEletroControl.dominio.endereco.dto.EnderecoDTO;
import com.fiap.grupo9.AppEletroControl.dominio.endereco.dto.EnderecoDTOFilter;
import com.fiap.grupo9.AppEletroControl.dominio.endereco.entitie.Endereco;
import com.fiap.grupo9.AppEletroControl.dominio.endereco.service.EnderecoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/enderecos")
@AllArgsConstructor
public class EnderecoController {
    private static final String requestReader = "usuario-auth-key";
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<Page<EnderecoDTO>> buscarComFiltro(
            @RequestHeader(requestReader) Long usuarioId,
            @Valid @ModelAttribute EnderecoDTOFilter filtro,
            @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(value = "tamanho", defaultValue = "10") Integer tamanho
    ) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);

        var enderecos = enderecoService.buscarComFiltro(pageRequest, filtro);
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> buscarPorId(
            @RequestHeader(requestReader) Long usuarioId,
            @PathVariable Long id
    ) {
        var pessoa = enderecoService.buscarPorId((id));
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> salvar(
            @RequestHeader(requestReader) Long usuarioId,
            @RequestBody EnderecoDTO endereco
    ) {
        var enderecoCadastrado = enderecoService.cadastrar(endereco);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((enderecoCadastrado.getId())).toUri();
        return ResponseEntity.created(uri).body(enderecoCadastrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizar(
            @RequestHeader(requestReader) Long usuarioId,
            @RequestBody Endereco endereco,
            @PathVariable Long id
    ) {
        var enderecoAtualizado = enderecoService.atualizar(id, endereco);
        return ResponseEntity.ok(enderecoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(
            @RequestHeader(requestReader) Long usuarioId,
            @PathVariable Long id
    ){
        enderecoService.remover(id);
        return ResponseEntity.noContent().build();
    }


}
