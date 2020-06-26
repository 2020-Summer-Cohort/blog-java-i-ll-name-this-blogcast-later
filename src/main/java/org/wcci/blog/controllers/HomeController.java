package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.storage.PostStorage;

@Controller
public class HomeController {

    private final PostStorage postStorage;


    public HomeController(PostStorage postStorage) {
        this.postStorage = postStorage;
    }

    @RequestMapping({"","/"})
    public String routeToHome(Model model){
        model.addAttribute("posts", postStorage.findAllPosts());
        return "home-template";
    }

}
