package com.dks.apilojavirtual.exception;

public class ProductNotFound extends RuntimeException{

    private static final long serialVersionID = 1;

    public ProductNotFound(String message){
        super();
    }

    public ProductNotFound(String message, Throwable cause){
        super(message, cause);
    }
}
