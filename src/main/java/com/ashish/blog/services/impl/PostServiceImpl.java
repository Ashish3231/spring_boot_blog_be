package com.ashish.blog.services.impl;

import com.ashish.blog.entities.Category;
import com.ashish.blog.entities.Post;
import com.ashish.blog.entities.User;
import com.ashish.blog.expections.ResourceNotFoundException;
import com.ashish.blog.payloads.PostDto;
import com.ashish.blog.payloads.UserDto;
import com.ashish.blog.repositories.CategoryRepo;
import com.ashish.blog.repositories.PostRepo;
import com.ashish.blog.repositories.UserRepo;
import com.ashish.blog.services.PostService;
import com.ashish.blog.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PostRepo postRepo;
    @Override
    public Post createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "user id", userId));
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "Category Id", categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setCategory(category);
        post.setUser(user);

        return this.postRepo.save(post);
    }

    @Override
    public Post updatePost(PostDto postDto) {
        return null;
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public void deletePostById(Integer postId) {

    }

    @Override
    public List<Post> getPostByCategory(Integer CatId) {
        return null;
    }

    @Override
    public List<Post> getPostByUser(Integer userId) {
        return null;
    }
}
