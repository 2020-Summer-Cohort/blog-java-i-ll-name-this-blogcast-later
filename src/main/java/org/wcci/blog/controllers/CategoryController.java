package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.entities.Category;
import org.wcci.blog.repositories.CategoryRepository;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.PostStorage;

@Controller
public class CategoryController {

    private CategoryStorage categoryStorage;
    private PostStorage postStorage;
    private CategoryRepository categoryRepository;


    public CategoryController(CategoryStorage categoryStorage, PostStorage postStorage, CategoryRepository categoryRepository) {
        this.categoryStorage = categoryStorage;
        this.postStorage = postStorage;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("categories/")
    public String showAllCategories(Model model){
        model.addAttribute("categories", categoryStorage.findAllCategories());
        model.addAttribute("posts", postStorage.findAllPosts());
        return "categories-template";
    }

    @PostMapping("categories/add")
    public String addCategory(String name){
        Category categoryToAdd = new Category(name);
        categoryRepository.save(categoryToAdd);
        return "redirect:/categories/";
    }


}
