package com.fiap.grupo9.AppEletroControl.dominio.usuario.service;

import com.fiap.grupo9.AppEletroControl.config.service.exception.ControllerNotFoundException;
import com.fiap.grupo9.AppEletroControl.config.service.exception.UsuarioNotFoundException;
import com.fiap.grupo9.AppEletroControl.dominio.usuario.repository.IUsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UsuarioService {

    private IUsuarioRepository usuarioRepository;

    public boolean existeUsuarioPorId(Long id) {
        log.info("Buscando usuario com id {}...", id);
        usuarioRepository.findById(id).orElseThrow(() ->
                new UsuarioNotFoundException("Usuario não existe"));
        return true;
    }
}
