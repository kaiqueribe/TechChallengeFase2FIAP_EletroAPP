package com.fiap.grupo9.AppEletroControl.config.interceptor.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidHeaderFieldException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String mensagem;

    public InvalidHeaderFieldException(String mensagem) {
        this.setMensagem(mensagem);
    }
}

