package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Category;
import org.wcci.blog.repositories.CategoryRepository;

@Service
public class CategoryStorage {

    private CategoryRepository categoryRepository;

    public CategoryStorage(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findCategoryByName(String name){
        return categoryRepository.findByName(name);
    }

    public Iterable<Category> findAllCategories(){
        return categoryRepository.findAll();
    }

    public void save(Category categoryToSave) {
        categoryRepository.save(categoryToSave);
    }

}
