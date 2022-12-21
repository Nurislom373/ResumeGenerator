package com.elbar.cv_gen.dto.project.category;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CategoryGetDTO extends GenericDTO {
    private String title;

    private String description;

    private Boolean isActive;
}
