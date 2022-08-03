package com.example.springbootasm.repository;

import com.example.springbootasm.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    public Page<Product> findAll(Pageable pageable);
}