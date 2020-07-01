package com.dks.apilojavirtual.resource;

import com.dks.apilojavirtual.domain.Product;
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

    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> listOrder(){
        return ResponseEntity.status(HttpStatus.OK).body(purchaseOrderService.list());
    }

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

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrder> editOrder(@RequestBody PurchaseOrder purchaseOrder,
                                                   @PathVariable("id") Long id){
        purchaseOrder.setId(id);
        purchaseOrderService.edit(purchaseOrder);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PurchaseOrder> deleteOrder(@PathVariable("id") Long id){
        purchaseOrderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getOrderById(@PathVariable("id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(purchaseOrderService.getPurchaseOrderById(id));
    }

    @PostMapping("/{id}/products")
    public ResponseEntity<Void> addProduct(@PathVariable("id") Long id,
                                           @RequestBody Product product){
        purchaseOrderService.saveProduct(id, product.getId());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).build();
    }

}
