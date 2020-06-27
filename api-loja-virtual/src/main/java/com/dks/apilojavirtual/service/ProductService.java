package com.dks.apilojavirtual.service;

import com.dks.apilojavirtual.domain.Client;
import com.dks.apilojavirtual.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> list();

    Client create (Product product);

    void edit (Product product);

    void delete (Long id);

    Client getProductById(Long id);

}
