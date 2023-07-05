package com.fiap.grupo9.AppEletroControl.dominio.eletrodomestico.service.exception;

public class ControllerNotFoundException extends RuntimeException{

    public ControllerNotFoundException(String mensagem){
        super(mensagem);
    }
}
