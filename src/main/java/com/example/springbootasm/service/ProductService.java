package com.example.springbootasm.service;

import com.example.springbootasm.entity.Product;
import com.example.springbootasm.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    final ProductRepository productRepository;
    public Product save(Product product) {
        Optional<Product> optionalFood =
                productRepository.findById(Long.valueOf(product.getId()));
        if (optionalFood.isPresent()) {
            return null;
        }
        return productRepository.save(product);
    }
    public Page<Product> findAll(int page, int limit){
        return productRepository.findAll(
                PageRequest.of(page-1, limit, Sort.Direction.ASC,"id"));
    }
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}