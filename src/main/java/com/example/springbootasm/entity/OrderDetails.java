package com.example.springbootasm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetails  {
    @EmbeddedId
    private OrderDetailId orderDetailId = new OrderDetailId();

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    @JsonBackReference
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    @JsonManagedReference
    private Product product;
    private Integer quantity;
    private BigDecimal unitPrice;
}