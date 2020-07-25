package com.example.springwebservice.domain.post;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT p FROM Post p ORDER BY id DESC")
    Stream<Post> findAllDesc();
}