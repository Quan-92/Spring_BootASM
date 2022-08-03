package com.example.springbootasm.api;

import com.example.springbootasm.entity.Category;
import com.example.springbootasm.entity.Product;
import com.example.springbootasm.entity.entityEnum.ProductStatus;
import com.example.springbootasm.repository.CategoryRepository;
import com.example.springbootasm.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/products")
public class ProductController {
    final ProductService productService;
    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> getDetail(@PathVariable String id) {
        Optional<Product> optionalFood = productService.findById(Long.valueOf(id));
        if (!optionalFood.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalFood.get());
    }

    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Optional<Category> category = categoryRepository.findById(product.getCategory().getId());
        if (!category.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(productService.save(product));
    }

    @RequestMapping(path = "/list",method = RequestMethod.GET)
    public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "1") int page,
                                     @RequestParam(value = "limit", defaultValue = "10") int limit,
                                     Model model) {
        return ResponseEntity.ok(model.addAttribute("Pageable", productService.findAll(page, limit)));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Product existProduct = optionalProduct.get();
        existProduct.setName(product.getName());
        existProduct.setImage(product.getImage());
        existProduct.setPrice(product.getPrice());
        existProduct.setDescription(product.getDescription());
        existProduct.setStatus(ProductStatus.SALE);
        return ResponseEntity.ok(productService.save(existProduct));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "delete/{id}")
    public  ResponseEntity<Product> delete(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Product existProduct = optionalProduct.get();
        existProduct.setName(product.getName());
        existProduct.setImage(product.getImage());
        existProduct.setPrice(product.getPrice());
        existProduct.setDescription(product.getDescription());
        existProduct.setStatus(ProductStatus.SALE);
        return ResponseEntity.ok(productService.save(existProduct));
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!productService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}