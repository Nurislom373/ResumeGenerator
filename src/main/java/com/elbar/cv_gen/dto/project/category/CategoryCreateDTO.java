package com.elbar.cv_gen.dto.project.category;

import com.elbar.cv_gen.dto.BaseDTO;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCreateDTO implements BaseDTO {
    @NotBlank(message = "category title cannot be null")
    @Size(min = 5, max = 150, message = "category title length must be between 5 and 150")
    private String title;

    @NotBlank(message = "category description cannot be null")
    @Size(min = 5, max = 150, message = "category description length must be between 5 and 300")
    private String description;

    private Boolean isActive;
}
