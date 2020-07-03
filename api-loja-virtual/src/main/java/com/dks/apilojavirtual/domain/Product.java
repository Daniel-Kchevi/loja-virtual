package com.dks.apilojavirtual.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Long amount;

    private BigDecimal value;

    //    @ManyToOne
//    @JoinColumn(name = "PURCHASEORDER_ID")
//    @JsonIgnore
//    @ManyToMany(mappedBy = "products")

//    @ManyToMany(cascade = {
//            CascadeType.ALL
//    }, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "order_product",
//            joinColumns = {
//                    @JoinColumn(name = "product_id")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "purchaseOrder_id")
//            }
//    )
//    @JsonIgnore
//    private List<PurchaseOrder> purchaseOrders = new ArrayList<>();

}
