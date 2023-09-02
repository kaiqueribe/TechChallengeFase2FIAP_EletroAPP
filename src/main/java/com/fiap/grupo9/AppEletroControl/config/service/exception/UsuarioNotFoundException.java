package com.fiap.grupo9.AppEletroControl.config.service.exception;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException(String mensagem){
        super(mensagem);
    }
}
