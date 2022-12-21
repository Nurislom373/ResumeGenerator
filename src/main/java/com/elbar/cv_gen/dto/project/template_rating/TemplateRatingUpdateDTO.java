package com.elbar.cv_gen.dto.project.template_rating;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TemplateRatingUpdateDTO extends GenericDTO {
    @NotNull(message = "template rating star count cannot be null")
    private Byte starCount;

    @NotNull(message = "template rating buy count cannot be null")
    private Integer buyCount;

    @NotNull(message = "template rating template id cannot be null")
    private Integer templateId;
}
