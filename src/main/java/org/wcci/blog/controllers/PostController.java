package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.entities.Author;
import org.wcci.blog.entities.Category;
import org.wcci.blog.entities.Post;
import org.wcci.blog.entities.Tag;
import org.wcci.blog.repositories.PostRepository;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.TagStorage;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class PostController {

    private PostStorage postStorage;
    private CategoryStorage categoryStorage;
    private AuthorStorage authorStorage;
    private TagStorage tagStorage;
    private PostRepository postRepository;

    public PostController(PostStorage postStorage, CategoryStorage categoryStorage, AuthorStorage authorStorage, TagStorage tagStorage, PostRepository postRepository) {
        this.postStorage = postStorage;
        this.categoryStorage = categoryStorage;
        this.authorStorage = authorStorage;
        this.tagStorage = tagStorage;
        this.postRepository = postRepository;
    }

    @RequestMapping("posts/{title}")
    public String showSinglePost(@PathVariable String title, Model model){
        model.addAttribute("singlePost", postStorage.findPostByTitle(title));
        return "post-template";
    }

    @RequestMapping("posts/")
    public String showAllPosts(Model model){
        model.addAttribute("manyPosts", postStorage.findAllPosts());
        return "posts-template";
    }

    @PostMapping("posts/add")
    public String addPost(String title, String description, Author author, String publishDate, Category category, Tag tag){
        LocalDate postDate = LocalDate.parse(publishDate);
        Post postToAdd = new Post(title, description, author, postDate, category, tag);
        postStorage.save(postToAdd);
        return "redirect:/posts/";
    }
}
