package com.examly.springapp.controller;

import com.examly.springapp.model.Category;
import com.examly.springapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @PostMapping
  public ResponseEntity<Category> createCategory(@RequestBody Category category) {
    Category createdCategory = categoryService.createCategory(category);
    return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Category>> getAllCategories() {
    return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
    Category category = categoryService.getCategoryById(id);
    if (category != null) {
      return new ResponseEntity<>(category, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
    Category updatedCategory = categoryService.updateCategory(id, category);
    if (updatedCategory != null) {
      return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
