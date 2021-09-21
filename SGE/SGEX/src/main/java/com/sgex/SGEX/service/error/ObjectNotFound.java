package com.sgex.SGEX.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFound extends RuntimeException{


    public ObjectNotFound()
    {
        super();
    }

    public ObjectNotFound(String s)
    {
        super(s);
    }

}
