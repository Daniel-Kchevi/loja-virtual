package com.dks.apilojavirtual.resource;

import com.dks.apilojavirtual.domain.Product;
import com.dks.apilojavirtual.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.list());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        productService.create(product);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();
        return ResponseEntity.created(uri).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> editProduct(@RequestBody Product product,
                                               @PathVariable("id") Long id){

        product.setId(id);
        productService.edit(product);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(id));
    }
}
