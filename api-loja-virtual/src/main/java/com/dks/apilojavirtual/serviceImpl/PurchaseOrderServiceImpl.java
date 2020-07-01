package com.dks.apilojavirtual.serviceImpl;

import com.dks.apilojavirtual.domain.Product;
import com.dks.apilojavirtual.domain.PurchaseOrder;
import com.dks.apilojavirtual.exception.PurchaseOrderNotFoud;
import com.dks.apilojavirtual.repository.ProductRepository;
import com.dks.apilojavirtual.repository.PurchaseOrderRepository;
import com.dks.apilojavirtual.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    private final String orderNotFund = "O pedido não foi encontrado.";

    @Override
    public List<PurchaseOrder> list() {
        return purchaseOrderRepository.findAll();
    }

    @Override
    public PurchaseOrder create(PurchaseOrder purchaseOrder) {
        purchaseOrder.setId(null);
        try{
            purchaseOrder.setProducts(listProduct(purchaseOrder.getProducts()));
            purchaseOrderRepository.save(purchaseOrder);
        }catch (Exception e){
            System.out.println(e.getCause());
        }
        return purchaseOrder;
    }

    private List<Product> listProduct(List<Product> purchaseOrders) {
        List<Product> productList = new ArrayList<>();
        for(Product product : purchaseOrders){
            Optional<Product> pro = productRepository.findById(product.getId());
            product = pro.get();
            productList.add(product);
        }
        return productList;
    }

    @Override
    public void edit(PurchaseOrder purchaseOrder) {
        try{
            checkingOrder(purchaseOrder.getId());
            purchaseOrderRepository.save(purchaseOrder);
        }catch (Exception e){
            throw new PurchaseOrderNotFoud(orderNotFund);
        }
    }

    @Override
    public void delete(Long id) {
        try{
            checkingOrder(id);
            purchaseOrderRepository.deleteById(id);
        }catch (Exception e){
            throw new PurchaseOrderNotFoud(orderNotFund);
        }

    }

    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
        Optional<PurchaseOrder> purc = null;
        PurchaseOrder purchaseOrder = new PurchaseOrder();

        try {
            purc = purchaseOrderRepository.findById(id);
            if (null==purc.get()){
                throw new PurchaseOrderNotFoud(orderNotFund);
            }
        }catch (Exception e){
            throw new PurchaseOrderNotFoud(orderNotFund);
        }

        purchaseOrder = purc.get();

        return purchaseOrder;
    }

    @Override
    public PurchaseOrder saveProduct(Long idOrder, Long idProduct) {
        Optional<Product> prod = productRepository.findById(idProduct);

        Product product = prod.get();
        List<Product> products = new ArrayList<>();
        products.add(product);

        PurchaseOrder purchaseOrder = getPurchaseOrderById(idOrder);
        purchaseOrder.setProducts(products);
        purchaseOrder.getClient().setPurchaseOrders(setOrder(purchaseOrder.getId()));

        return purchaseOrderRepository.save(purchaseOrder);
    }

    private List<PurchaseOrder> setOrder(Long id) {
        List<PurchaseOrder> purchaseOrders = new ArrayList<>();
        purchaseOrders.add(getPurchaseOrderById(id));
        return purchaseOrders;
    }

    private void checkingOrder(Long id) {
        getPurchaseOrderById(id);
    }
}
