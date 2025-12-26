package com.examly.springapp.service;

import com.examly.springapp.model.Category;
import java.util.List;

public interface CategoryService {
  Category createCategory(Category category);
  List<Category> getAllCategories();
  Category getCategoryById(Long id);
  Category updateCategory(Long id, Category category); // Added just in case
}
