package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnathorizedClient extends RuntimeException{

    public UnathorizedClient(String msg){super(msg);}
}
