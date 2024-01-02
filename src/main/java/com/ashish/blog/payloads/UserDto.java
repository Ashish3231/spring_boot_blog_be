package com.ashish.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 3, message = "Name must be length of three chars !!")
    private  String name;

    @Email(message = "Email Address is not valid !!")
    @NotEmpty
    private String email;

    @NotEmpty
    private String about;

    @NotEmpty
    @Size(min = 4, max = 10, message = "Password must be length a range 4 to 10 chars !!")
    private String password;

}
