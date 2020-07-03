package com.dks.apilojavirtual.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PurchaseOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToMany
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public void addProduct(Product product) {
        OrderItem orderItem = new OrderItem(product);
        orderItems.add(orderItem);
    }
}
