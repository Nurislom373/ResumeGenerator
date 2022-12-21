package com.elbar.cv_gen.dto.project.template_save;

import com.elbar.cv_gen.dto.BaseDTO;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TemplateSaveCreateDTO implements BaseDTO {
    @NotNull
    @Min(1)
    private Integer userId;
    @NotNull
    @Min(1)
    private Integer templateId;

}
