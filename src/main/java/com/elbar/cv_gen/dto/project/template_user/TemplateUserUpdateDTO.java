package com.elbar.cv_gen.dto.project.template_user;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TemplateUserUpdateDTO extends GenericDTO {
    @NotNull
    private Boolean isEdit;
}
