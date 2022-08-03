package com.example.springbootasm.entity;

import com.example.springbootasm.entity.basic.BaseEntity;
import com.example.springbootasm.entity.entityEnum.ProductStatus;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private String image;
    private double price;
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private ProductStatus status;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;


}