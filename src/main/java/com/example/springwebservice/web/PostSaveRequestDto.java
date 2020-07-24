package com.example.springwebservice.web;

import com.example.springwebservice.domain.post.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String author;

    public Post toEntity() {
        return Post.builder().author(author).content(content).title(title).build();
    }

    @Builder
    public PostSaveRequestDto(String author, String content, String title) {
        this.author = author;
        this.content = content;
        this.title = title;
    }

}
