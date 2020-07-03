package com.dks.apilojavirtual.serviceImpl;

import com.dks.apilojavirtual.domain.Client;
import com.dks.apilojavirtual.domain.Product;
import com.dks.apilojavirtual.exception.ProductNotFound;
import com.dks.apilojavirtual.repository.ProductRepository;
import com.dks.apilojavirtual.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final String productNotFund = "O produto não foi encontrado.";

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> list() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    @Override
    public void edit(Product product) {
        try {
            checkingProduct(product.getId());
            productRepository.save(product);
        }catch (Exception e){
            throw new ProductNotFound(productNotFund);
        }
    }

    @Override
    public void delete(Long id) {
        try{
            checkingProduct(id);
            productRepository.deleteById(id);
        }catch (Exception e){
            throw new ProductNotFound(productNotFund);
        }
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> prod = null;
        Product product = new Product();
        try {
            prod = productRepository.findById(id);
            if (null==prod.get()){
                throw new ProductNotFound(productNotFund);
            }
        }catch (Exception e){
            throw new ProductNotFound(productNotFund);
        }

        product = prod.get();

        return product;
    }

    private void checkingProduct(Long id) {
        getProductById(id);
    }

}
