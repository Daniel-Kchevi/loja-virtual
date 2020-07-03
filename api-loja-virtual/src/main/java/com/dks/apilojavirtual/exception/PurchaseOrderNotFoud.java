package com.dks.apilojavirtual.exception;

public class PurchaseOrderNotFoud extends RuntimeException{

    private static final long serialVersionID = 1;

    public PurchaseOrderNotFoud(String message){
        super();
    }

    public PurchaseOrderNotFoud(String message, Throwable cause){
        super(message, cause);
    }
}
