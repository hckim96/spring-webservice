package com.example.springwebservice.domain.post;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    PostRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void getPosts() {
        Post n = Post.builder().author("author").content("content").title("title").build();

        postsRepository.save(n);
        List<Post> postsList = postsRepository.findAll();

        Post post = postsList.get(0);
        assertEquals("author", post.getAuthor());
        assertEquals("content", post.getContent());
    }

    @Test
    public void checkDateInEntity() {
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Post.builder().author("author").content("content").title("title").build());

        List<Post> posts = postsRepository.findAll();
        Post post = posts.get(0);

        assertTrue(post.getCreatedDate().isAfter(now));
        assertTrue(post.getModifiedDate().isAfter(now));

    }

}