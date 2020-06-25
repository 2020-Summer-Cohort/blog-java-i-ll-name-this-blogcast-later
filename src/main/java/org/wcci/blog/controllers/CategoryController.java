package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.entities.Category;
import org.wcci.blog.storage.CategoryStorage;

@Controller
public class CategoryController {

    private CategoryStorage categoryStorage;

    public CategoryController(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
    }

    @RequestMapping("categories/{name}")
    public String showSingleCategory(@PathVariable String name, Model model){
        model.addAttribute("category", categoryStorage.findCategoryByName(name));
        return "category-template";
    }

    @RequestMapping("categories/")
    public String showAllCategories(Model model){
        model.addAttribute("categories", categoryStorage.findAllCategories());
        return "categories-template";
    }

    @PostMapping("categories/add")
    public String addCategory(String name){
        Category categoryToAdd = new Category(name);
        categoryStorage.save(categoryToAdd);
        return "redirect:/";
    }


}
