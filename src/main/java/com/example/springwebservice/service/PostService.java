package com.example.springwebservice.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.example.springwebservice.domain.post.PostRepository;
import com.example.springwebservice.dto.PostSaveRequestDto;
import com.example.springwebservice.dto.PostMainResponseDto;

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

    @Transactional
    public List<PostMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().map(PostMainResponseDto::new).collect(Collectors.toList());
    }
}