package com.elbar.cv_gen.dto.project.template_gen;

import com.elbar.cv_gen.dto.BaseDTO;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TemplateGenCreateDTO implements BaseDTO {
    private Integer userId;
    private Integer templateId;
    private String fields;
}
