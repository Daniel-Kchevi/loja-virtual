package com.dks.apilojavirtual.exception;

public class ClientNotFound extends RuntimeException{

    private static final long serialVersionID = 1;

    public ClientNotFound(String message){
        super();
    }

    public ClientNotFound(String message, Throwable cause){
        super(message, cause);
    }
}
