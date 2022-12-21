package com.elbar.cv_gen.dto.project.category;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdateDTO extends GenericDTO {
    @NotBlank(message = "category title cannot be null")
    @Size(min = 5, max = 150, message = "category title length must be between 5 and 150")
    private String title;

    @NotBlank(message = "category description cannot be null")
    @Size(min = 5, max = 150, message = "category description length must be between 5 and 150")
    private String description;

    @NotNull(message = "category is active cannot be null")
    private Boolean isActive;
}
