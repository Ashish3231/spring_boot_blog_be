package com.ashish.blog.controllers;

import com.ashish.blog.payloads.ApiResponse;
import com.ashish.blog.payloads.UserDto;
import com.ashish.blog.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /****
     * create user
     */
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createUserDto = userService.createUser(userDto);
        return ResponseEntity.ok(createUserDto);
    }

    /***
     * <p>
     * getUsers
     */
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     *
     */
    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUser(@PathVariable Integer userId ){
        UserDto user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){
        UserDto user = userService.updateUser(userDto, userId);
        return  ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
        userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted user id: "+ userId, true), HttpStatus.CREATED);

    }

}
