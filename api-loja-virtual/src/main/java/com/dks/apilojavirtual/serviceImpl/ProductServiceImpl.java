package com.dks.apilojavirtual.serviceImpl;

import com.dks.apilojavirtual.domain.Client;
import com.dks.apilojavirtual.domain.Product;
import com.dks.apilojavirtual.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public Client create(Product product) {
        return null;
    }

    @Override
    public void edit(Product product) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Client getProductById(Long id) {
        return null;
    }
}
