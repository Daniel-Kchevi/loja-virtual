package com.dks.apilojavirtual.resource;

import com.dks.apilojavirtual.domain.PurchaseOrder;
import com.dks.apilojavirtual.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/order")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity<PurchaseOrder> createOrder(@RequestBody PurchaseOrder purchaseOrder){

        purchaseOrderService.create(purchaseOrder);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(purchaseOrder.getId())
                .toUri();

        return ResponseEntity.created(uri).body(purchaseOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PurchaseOrder> deleteOrder(@PathVariable("id") Long id){
        purchaseOrderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable("id")Long id){
        PurchaseOrder purchaseOrder = purchaseOrderService.getPurchaseOrderById(id);
        return ResponseEntity.status(HttpStatus.OK).body(purchaseOrder);
    }

}
