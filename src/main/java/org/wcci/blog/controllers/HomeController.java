package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.TagStorage;

@Controller
public class HomeController {

    private final AuthorStorage authorStorage;
    private final CategoryStorage categoryStorage;
    private final PostStorage postStorage;
    private final TagStorage tagStorage;

    public HomeController(AuthorStorage authorStorage, CategoryStorage categoryStorage, PostStorage postStorage, TagStorage tagStorage) {
        this.authorStorage = authorStorage;
        this.categoryStorage = categoryStorage;
        this.postStorage = postStorage;
        this.tagStorage = tagStorage;
    }

    @RequestMapping({"","/"})
    public String routeToHome(Model model){
        model.addAttribute("authors", authorStorage.findAllAuthors());
        model.addAttribute("categories", categoryStorage.findAllCategories());
        model.addAttribute("posts", postStorage.findAllPosts());
        model.addAttribute("tags", tagStorage.findAllTags());
        return "home-template";
    }

}
