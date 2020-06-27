package com.dks.apilojavirtual.serviceImpl;

import com.dks.apilojavirtual.domain.Client;
import com.dks.apilojavirtual.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Override
    public List<PurchaseOrderService> list() {
        return null;
    }

    @Override
    public Client create(PurchaseOrderService purchaseOrderService) {
        return null;
    }

    @Override
    public void edit(PurchaseOrderService purchaseOrderService) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Client getPurchaseOrderServiceById(Long id) {
        return null;
    }
}
