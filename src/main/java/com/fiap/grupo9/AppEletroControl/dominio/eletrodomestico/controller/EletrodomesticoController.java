package com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.controller;

import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.dto.EletrodomesticoDTO;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.entitie.Eletrodomestico;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.service.EletrodomesticoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/eletrodomesticos")
@Slf4j
@AllArgsConstructor
public class EletrodomesticoController {

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
    public ResponseEntity<EletrodomesticoDTO> buscarPorId(@PathVariable Long id) {
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
    public ResponseEntity<Eletrodomestico> atualizar(@RequestBody EletrodomesticoDTO eletrodomesticoDTO, @PathVariable Long id) {
        var eletrodomesticoAtualizado = eletrodomesticoService.atualizar(id, eletrodomesticoDTO);
        return ResponseEntity.ok(eletrodomesticoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        eletrodomesticoService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
