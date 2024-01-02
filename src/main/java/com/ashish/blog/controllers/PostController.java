package com.ashish.blog.controllers;

import com.ashish.blog.entities.Post;
import com.ashish.blog.payloads.PostDto;
import com.ashish.blog.services.PostService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private ModelMapper modelMapper;

    // create post
    @PostMapping("/user/{userId}/category/{categoryId}")
    public ResponseEntity<PostDto> createUser(
            @Valid @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId) {
         Post post = this.postService.createPost(postDto,userId,categoryId);
         return ResponseEntity.ok(this.modelMapper.map(post, PostDto.class));
    }
}
