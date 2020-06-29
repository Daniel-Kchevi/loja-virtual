package com.dks.apilojavirtual.serviceImpl;

import com.dks.apilojavirtual.domain.Client;
import com.dks.apilojavirtual.domain.PurchaseOrder;
import com.dks.apilojavirtual.exception.PurchaseOrderNotFoud;
import com.dks.apilojavirtual.repository.PurchaseOrderRepository;
import com.dks.apilojavirtual.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final String orderNotFund = "O pedido não foi encontrado.";

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public List<PurchaseOrder> list() {
        return purchaseOrderRepository.findAll();
    }

    @Override
    public PurchaseOrder create(PurchaseOrder purchaseOrder) {
        purchaseOrder.setId(null);
        return purchaseOrderRepository.save(purchaseOrder);
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

    private void checkingOrder(Long id) {
        getPurchaseOrderById(id);
    }
}
