package com.dks.apilojavirtual.serviceImpl;

import com.dks.apilojavirtual.domain.OrderItem;
import com.dks.apilojavirtual.domain.Product;
import com.dks.apilojavirtual.domain.PurchaseOrder;
import com.dks.apilojavirtual.exception.PurchaseOrderNotFoud;
import com.dks.apilojavirtual.repository.ProductRepository;
import com.dks.apilojavirtual.repository.PurchaseOrderRepository;
import com.dks.apilojavirtual.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    private final String orderNotFund = "O pedido não foi encontrado.";

    @Override
    public PurchaseOrder create(PurchaseOrder purchaseOrder) {
        purchaseOrder.setId(null);

        Set<OrderItem> listOrder = new HashSet<>();
        listOrder = purchaseOrder.getOrderItems();

        purchaseOrder.setOrderItems(new HashSet<>());

        Product product = null;

        try{
            for(OrderItem item : listOrder){
                Optional<String> op = Optional.empty();
                Optional<Product> prod = productRepository.findById(item.getProduct().getId());
                if(op.equals(prod)){
                    product = new Product();
                }else{
                    product = prod.get();
                }
                purchaseOrder.addProduct(product);
            }

            purchaseOrderRepository.save(purchaseOrder);
        }catch (Exception e){
            System.out.println(e.getCause());
        }
        return purchaseOrder;
    }

    @Override
    public void delete(Long id) {
        try{
//            checkingOrder(id);
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

//    private void checkingOrder(Long id) {
//        getPurchaseOrderById(id);
//    }
}
