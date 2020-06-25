package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.entities.Tag;
import org.wcci.blog.storage.TagStorage;

@Controller
public class TagController {

    private TagStorage tagStorage;

    public TagController(TagStorage tagStorage) {
        this.tagStorage = tagStorage;
    }

    @RequestMapping("tags/{name}")
    public String showSingleTag(@PathVariable String name, Model model){
        model.addAttribute("tag", tagStorage.findTagByName(name));
        return "tag-template";
    }

    @RequestMapping("tags/")
    public String showAllTags(Model model){
        model.addAttribute("tags", tagStorage.findAllTags());
        return "tags-template";
    }

    @PostMapping("tags/add")
    public String addTag(String name){
        Tag tagToAdd = new Tag(name);
        tagStorage.save(tagToAdd);
        return "redirect:/";
    }
}
