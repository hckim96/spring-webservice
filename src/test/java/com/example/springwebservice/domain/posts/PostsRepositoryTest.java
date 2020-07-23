package com.example.springwebservice.domain.posts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void getPosts() {
        Posts n = Posts.builder().author("author").content("content").title("title").build();

        postsRepository.save(n);
        List<Posts> postsList = postsRepository.findAll();

        Posts post = postsList.get(0);
        assertEquals("author", post.getAuthor());
        assertEquals("content", post.getContent());
    }
}