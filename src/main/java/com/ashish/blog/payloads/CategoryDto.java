package com.ashish.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private  int id;

    @NotEmpty
    @Size(max= 15, message = "Title must be of less than 15 chars")
    private String categoryTitle;

    @NotEmpty
    private String categoryDescription;
}
