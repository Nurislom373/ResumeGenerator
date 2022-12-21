package com.elbar.cv_gen.dto.project.template_save;

import com.elbar.cv_gen.annotation.IdConstraint;
import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TemplateSaveUpdateDTO extends GenericDTO {
    @IdConstraint
    private Integer userId;
    @IdConstraint
    private Integer templateId;
}
