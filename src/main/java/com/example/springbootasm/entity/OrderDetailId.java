package com.example.springbootasm.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class OrderDetailId implements Serializable {
    private static final long serialVersionUID = 8031989367819720152L;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "food_id")
    private String foodId;
}