package com.example.springbootasm.api;

import com.example.springbootasm.entity.Category;
import com.example.springbootasm.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/categories")
public class CategoryController {
    final CategoryService categoryService;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> processSaveCategory(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.save(category));
    }
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> getDetail(@PathVariable Long id) {
        Optional<Category> optionalCategory = categoryService.findById(id);
        if (!optionalCategory.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalCategory.get());
    }
    @RequestMapping(path = "list" , method = RequestMethod.GET)
    public ResponseEntity<?> findAll(@RequestParam(value = "page",defaultValue = "1") int page,
                                     @RequestParam(value = "limit",defaultValue = "10")int limit,
                                     Model model){
        model.addAttribute("Pageable",categoryService.findAll(page, limit));
        return ResponseEntity.ok(model.addAttribute("Pageable", categoryService.findAll(page, limit)));
    }
    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {
        Optional<Category> optionalCategory = categoryService.findById(id);
        if (!optionalCategory.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Category existCategory = optionalCategory.get();
        // map object
        existCategory.setName(category.getName());
        return ResponseEntity.ok(categoryService.save(existCategory));
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/delete{id}")
    public ResponseEntity<Category> delete(@PathVariable Long id, @RequestBody Category category) {
        Optional<Category> optionalCategory = categoryService.findById(id);
        if (!optionalCategory.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Category existCategory = optionalCategory.get();
        // map object
        existCategory.setName(category.getName());
        return ResponseEntity.ok(categoryService.save(existCategory));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!categoryService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}