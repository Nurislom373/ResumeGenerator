package com.elbar.cv_gen.dto.project.template_user;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TemplateUserGetDTO extends GenericDTO {
    private Integer templateId;
    private Integer userId;
    private Boolean isEdit;
}
