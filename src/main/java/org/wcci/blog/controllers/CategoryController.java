package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.entities.Category;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.PostStorage;

@Controller
public class CategoryController {

    private CategoryStorage categoryStorage;
    private PostStorage postStorage;

    public CategoryController(CategoryStorage categoryStorage, PostStorage postStorage) {
        this.categoryStorage = categoryStorage;
        this.postStorage = postStorage;
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
        categoryStorage.save(categoryToAdd);
        return "redirect:/";
    }


}
