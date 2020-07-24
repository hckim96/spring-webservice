package com.example.springwebservice.web;

import com.example.springwebservice.domain.post.PostRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
    private PostRepository postsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/post")
    public void savePost(@RequestBody PostSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }

}