package com.example.springwebservice.web;

import com.example.springwebservice.dto.PostSaveRequestDto;
import com.example.springwebservice.service.PostService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
    private PostService postService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/post")
    public Long savePost(@RequestBody PostSaveRequestDto dto) {
        return postService.save(dto);
    }
}
