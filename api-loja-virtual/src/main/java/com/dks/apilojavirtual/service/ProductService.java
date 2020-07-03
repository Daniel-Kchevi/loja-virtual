package com.dks.apilojavirtual.service;

import com.dks.apilojavirtual.domain.Client;
import com.dks.apilojavirtual.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> list();

    Product create (Product product);

    void edit (Product product);

    void delete (Long id);

    Product getProductById(Long id);

}
