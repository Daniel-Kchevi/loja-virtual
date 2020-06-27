package com.dks.apilojavirtual.service;

import com.dks.apilojavirtual.domain.Client;
import com.dks.apilojavirtual.domain.Product;

import java.util.List;

public interface PurchaseOrderService {

    List<PurchaseOrderService> list();

    Client create (PurchaseOrderService purchaseOrderService);

    void edit (PurchaseOrderService purchaseOrderService);

    void delete (Long id);

    Client getPurchaseOrderServiceById(Long id);
}
