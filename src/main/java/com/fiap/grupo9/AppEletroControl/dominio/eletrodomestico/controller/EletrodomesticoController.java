package com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.controller;

import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.dto.EletrodomesticoDTO;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.entitie.Eletrodomestico;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.service.EletrodomesticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
//att

@RestController
@RequestMapping("/eletrodomesticos")
public class EletrodomesticoController {

    @Autowired
    private EletrodomesticoService eletrodomesticoService;

    @GetMapping
    public ResponseEntity<Page<EletrodomesticoDTO>> buscarTodos(
            @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(value = "tamanho", defaultValue = "10") Integer tamanho
    ) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);

        var eletrodomesticos = eletrodomesticoService.buscarTodos(pageRequest);
        return ResponseEntity.ok(eletrodomesticos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EletrodomesticoDTO> buscarPorId(@PathVariable UUID id) {
        var eletrodomestico = eletrodomesticoService.buscarPorId(id);
        return ResponseEntity.ok(eletrodomestico);
    }

    @PostMapping
    public ResponseEntity<EletrodomesticoDTO> salvar(@RequestBody EletrodomesticoDTO eletrodomestico) {
        var eletrodomesticoCadastrado = eletrodomesticoService.cadastrar(eletrodomestico);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((eletrodomesticoCadastrado.getId())).toUri();
        return ResponseEntity.created(uri).body(eletrodomesticoCadastrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Eletrodomestico> atualizar(@RequestBody Eletrodomestico eletrodomestico, @PathVariable UUID id) {
        var eletrodomesticoAtualizado = eletrodomesticoService.atualizar(id, eletrodomestico);
        return ResponseEntity.ok(eletrodomesticoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable UUID id) {
        eletrodomesticoService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
