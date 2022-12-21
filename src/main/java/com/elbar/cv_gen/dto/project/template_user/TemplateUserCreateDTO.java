package com.elbar.cv_gen.dto.project.template_user;

import com.elbar.cv_gen.annotation.IdConstraint;
import com.elbar.cv_gen.dto.BaseDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TemplateUserCreateDTO implements BaseDTO {
    @IdConstraint
    private Integer templateId;
    @IdConstraint
    private Integer userId;
}
