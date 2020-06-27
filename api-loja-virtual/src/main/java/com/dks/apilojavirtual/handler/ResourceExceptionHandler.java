package com.dks.apilojavirtual.handler;

import com.dks.apilojavirtual.domain.DetailsError;
import com.dks.apilojavirtual.exception.ClientNotFound;
import com.dks.apilojavirtual.exception.ProductNotFound;
import com.dks.apilojavirtual.exception.PurchaseOrderNotFoud;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ClientNotFound.class)
    public ResponseEntity<DetailsError> handlerClientNotFound(ClientNotFound cli,
                                                              HttpServletRequest request){
        DetailsError error = new DetailsError("O cliente não foi encontrado.", 404L, System.currentTimeMillis());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<DetailsError> handlerClientNotFound(ProductNotFound prod,
                                                              HttpServletRequest request){
        DetailsError error = new DetailsError("O produto não foi encontrado.", 404L, System.currentTimeMillis());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(PurchaseOrderNotFoud.class)
    public ResponseEntity<DetailsError> handlerClientNotFound(PurchaseOrderNotFoud ord,
                                                              HttpServletRequest request){
        DetailsError error = new DetailsError("O pedido não foi encontrado.", 404L, System.currentTimeMillis());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
