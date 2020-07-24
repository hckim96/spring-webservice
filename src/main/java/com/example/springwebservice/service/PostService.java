package com.example.springwebservice.service;

import javax.transaction.Transactional;

import com.example.springwebservice.domain.post.PostRepository;
import com.example.springwebservice.web.PostSaveRequestDto;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostService {
    private PostRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }
}