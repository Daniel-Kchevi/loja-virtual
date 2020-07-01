package com.dks.apilojavirtual.service;

import com.dks.apilojavirtual.domain.Product;
import com.dks.apilojavirtual.domain.PurchaseOrder;

import java.util.List;

public interface PurchaseOrderService {

    List<PurchaseOrder> list();

    PurchaseOrder create (PurchaseOrder purchaseOrder);

    void edit (PurchaseOrder purchaseOrder);

    void delete (Long id);

    PurchaseOrder getPurchaseOrderById(Long id);

    PurchaseOrder saveProduct(Long idOrder, Long idProduct);
}
