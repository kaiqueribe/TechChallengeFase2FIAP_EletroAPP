package com.fiap.grupo9.AppEletroControl.config.interceptor.exception;

import com.fiap.grupo9.AppEletroControl.config.service.exception.DefaultError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class HeaderFieldExceptionHandler {
    private DefaultError error = new DefaultError();

    @ExceptionHandler
    public ResponseEntity<DefaultError> handleInvalidHeaderFieldException(
            InvalidHeaderFieldException exception,
            HttpServletRequest request
    ) {
            HttpStatus status = HttpStatus.PRECONDITION_FAILED;
            error.setTimestamp(Instant.now());
            error.setStatus(status.value());
            error.setError("Acesso negado");
            error.setMessage(exception.getMensagem());
            error.setPath(request.getRequestURI());
            return ResponseEntity.status(status).body(this.error);
    }
}
