package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.entities.Tag;
import org.wcci.blog.repositories.TagRepository;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.TagStorage;

@Controller
public class TagController {

    private TagStorage tagStorage;
    private PostStorage postStorage;

    public TagController(TagStorage tagStorage, PostStorage postStorage) {
        this.tagStorage = tagStorage;
        this.postStorage = postStorage;
    }

    @RequestMapping("tags/")
    public String showAllTags(Model model){
        model.addAttribute("tags", tagStorage.findAllTags());
        model.addAttribute("posts",postStorage.findAllPosts());
        return "tags-template";
    }

    @PostMapping("tags/add")
    public String addTag(String name){
        Tag tagToAdd = new Tag(name);
        tagStorage.save(tagToAdd);
        return "redirect:/tags/";
    }
}
