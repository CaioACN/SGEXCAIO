package com.sgex.SGEX.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNaoEcontradoException extends RuntimeException{

    public UsuarioNaoEcontradoException(String s) {
        super(s);
    }
}
