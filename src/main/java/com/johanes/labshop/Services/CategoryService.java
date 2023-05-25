package com.johanes.labshop.Services;

import com.johanes.labshop.Objects.Category;
import com.johanes.labshop.data.CategoryRepository;
import com.johanes.labshop.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Category category) {
        categoryRepository.deleteById(category.getId());
    }

    public void deleteCategoryById(long id) {
        categoryRepository.deleteById(id);
    }
}
