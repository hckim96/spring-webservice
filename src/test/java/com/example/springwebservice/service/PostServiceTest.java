package com.example.springwebservice.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.example.springwebservice.domain.post.Post;
import com.example.springwebservice.domain.post.PostRepository;
import com.example.springwebservice.dto.PostSaveRequestDto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {
    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    @AfterEach
    public void cleanup() {
        postRepository.deleteAll();
    }

    @Test
    public void saveTest() {
        PostSaveRequestDto dto = PostSaveRequestDto.builder().content("content").title("title").author("author")
                .build();

        postService.save(dto);
        List<Post> postList = postRepository.findAll();
        Post post = postList.get(2); // 0,1 inserted at start

        assertTrue(post.getAuthor().equals("author"));
        assertTrue(post.getContent().equals("content"));
        assertTrue(post.getTitle().equals("title"));
    }

}