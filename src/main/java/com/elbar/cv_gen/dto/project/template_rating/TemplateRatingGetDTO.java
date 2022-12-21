package com.elbar.cv_gen.dto.project.template_rating;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TemplateRatingGetDTO extends GenericDTO {
    private Byte starCount;
    private Integer buyCount;
    private Integer templateId;
}
