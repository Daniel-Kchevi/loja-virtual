package com.dks.apilojavirtual.service;

import com.dks.apilojavirtual.domain.PurchaseOrder;

public interface PurchaseOrderService {

    PurchaseOrder create (PurchaseOrder purchaseOrder);

    void delete (Long id);

    PurchaseOrder getPurchaseOrderById(Long id);

}
