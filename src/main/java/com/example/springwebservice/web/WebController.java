package com.example.springwebservice.web;

import com.example.springwebservice.service.PostService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller

@AllArgsConstructor
public class WebController {
    private PostService postService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("post", postService.findAllDesc());
        return "main";
    }

}