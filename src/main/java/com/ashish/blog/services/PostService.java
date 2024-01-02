package com.ashish.blog.services;

import com.ashish.blog.entities.Post;
import com.ashish.blog.payloads.PostDto;

import java.util.List;

public interface PostService {

    //create
    Post createPost(PostDto postDto, Integer userId, Integer categoryId);

    //update
    Post updatePost(PostDto postDto);

    //Get
    Post getPostById(Integer postId);

    //get All Posts

    List<Post> getAllPost();

    //Delete Post

    void deletePostById(Integer postId);

    //get all post by category
    List<Post> getPostByCategory(Integer CatId);

    //get all posts by user
    List<Post> getPostByUser(Integer userId);
}
