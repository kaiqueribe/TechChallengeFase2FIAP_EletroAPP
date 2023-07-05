package com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.controller.exception;

import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.service.exception.ControllerNotFoundException;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.service.exception.DatabaseException;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.service.exception.DefaultError;
import com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.service.exception.NoContentException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ControllerExceptionHandler {
    private DefaultError error = new DefaultError();

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<DefaultError> entityNotFound(ControllerNotFoundException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Entidade não encontrada");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(this.error);

    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<DefaultError> entityNotFound(DatabaseException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Database Error");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(this.error);

    }

//    @ExceptionHandler(DatabaseException.class)
//    public ResponseEntity<DefaultError> entityNotFound(NoContentException exception, HttpServletRequest request) {
//        HttpStatus status = HttpStatus.NOT_FOUND;
//        error.setTimestamp(Instant.now());
//        error.setStatus(status.value());
//        error.setError("Entidade Não Encontrada");
//        error.setMessage(exception.getMessage());
//        error.setPath(request.getRequestURI());
//        return ResponseEntity.status(status).body(this.error);
//
//    }

}