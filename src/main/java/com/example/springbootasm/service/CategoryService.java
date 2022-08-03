package com.example.springbootasm.service;

import com.example.springbootasm.entity.Category;
import com.example.springbootasm.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    final CategoryRepository categoryRepository;
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
    public Page<Category> findAll(int page, int limit){
        return categoryRepository.findAll(
                PageRequest.of(page-1, limit, Sort.Direction.ASC,"id"));
    }
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}