package com.examly.springapp.service;

import com.examly.springapp.model.Category;
import com.examly.springapp.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepo categoryRepo;

  @Override
  public Category createCategory(Category category) {
    return categoryRepo.save(category);
  }

  @Override
  public List<Category> getAllCategories() {
    return categoryRepo.findAll();
  }

  @Override
  public Category getCategoryById(Long id) {
    return categoryRepo.findById(id).orElse(null);
  }

  @Override
  public Category updateCategory(Long id, Category category) {
    Category existingCategory = categoryRepo.findById(id).orElse(null);
    if (existingCategory != null) {
      existingCategory.setCategoryName(category.getCategoryName());
      return categoryRepo.save(existingCategory);
    }
    return null;
  }
}
