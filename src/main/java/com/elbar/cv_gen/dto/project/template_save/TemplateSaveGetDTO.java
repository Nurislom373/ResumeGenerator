package com.elbar.cv_gen.dto.project.template_save;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TemplateSaveGetDTO extends GenericDTO {
    private Integer templateId;
    private Integer userId;
}
