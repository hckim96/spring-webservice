package com.example.springwebservice.web;

import java.util.Arrays;

import com.example.springwebservice.dto.PostSaveRequestDto;
import com.example.springwebservice.service.PostService;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
    private PostService postService;
    private Environment env;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/post")
    public Long savePost(@RequestBody PostSaveRequestDto dto) {
        return postService.save(dto);
    }

    @GetMapping("/profile")
    public String getProfile() {
        String[] a = env.getActiveProfiles();
        return Arrays.stream(a).findFirst().orElse("");
    }

}
