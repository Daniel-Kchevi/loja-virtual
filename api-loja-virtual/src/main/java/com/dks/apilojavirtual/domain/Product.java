package com.dks.apilojavirtual.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Long amount;

    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "PURCHASEORDER_ID")
    @JsonIgnore
    private PurchaseOrder purchaseOrder;

}
