package com.fiap.grupo9.AppEletroControl.config.service.exception;

public class ControllerNotFoundException extends RuntimeException{

    public ControllerNotFoundException(String mensagem){
        super(mensagem);
    }
}
