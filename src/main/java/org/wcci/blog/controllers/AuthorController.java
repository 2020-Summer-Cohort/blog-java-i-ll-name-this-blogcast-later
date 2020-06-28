package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.entities.Author;
import org.wcci.blog.repositories.AuthorRepository;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.PostStorage;

@Controller
public class AuthorController {

    private AuthorStorage authorStorage;
    private PostStorage postStorage;
    private AuthorRepository authorRepository;


    public AuthorController(AuthorStorage authorStorage, PostStorage postStorage, AuthorRepository authorRepository) {
        this.authorStorage = authorStorage;
        this.postStorage = postStorage;
        this.authorRepository = authorRepository;
    }

    @RequestMapping("authors/")
    public String showAllAuthors(Model model){
        model.addAttribute("authors", authorStorage.findAllAuthors());
        model.addAttribute("posts",postStorage.findAllPosts());
        return "authors-template";
    }

    @PostMapping("authors/add")
    public String addAuthor(String firstName, String lastName){
        Author authorToAdd = new Author(firstName,lastName);
        authorRepository.save(authorToAdd);
        return "redirect:/authors/";
    }
}
