package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.entities.Author;
import org.wcci.blog.storage.AuthorStorage;

@Controller
public class AuthorController {

    private AuthorStorage authorStorage;

    public AuthorController(AuthorStorage authorStorage) {
        this.authorStorage = authorStorage;
    }

    @RequestMapping("authors/{id}")
    public String showSingleAuthor(@PathVariable Long id, Model model){
        model.addAttribute("author", authorStorage.findAuthorById(id));
        return "author-template";
    }

    @PostMapping("authors/add")
    public String addAuthor(String firstName, String lastName){
        Author authorToAdd = new Author(firstName,lastName);
        authorStorage.save(authorToAdd);
        return "redirect:/authors/";
    }
}
