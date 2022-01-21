package com.br.equiplano.exception;


import org.springframework.web.bind.annotation.ExceptionHandler;

public class ClientCpfException extends RuntimeException{

    public ClientCpfException(String message) {
        super(message);
    }
}
