package com.elbar.cv_gen.dto.project.template_user;

import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.entity.auth.auth_user.AuthUserEntity;
import com.elbar.cv_gen.entity.project.template.TemplateEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TemplateUserDetailDTO extends GenericDTO {
    private AuthUserEntity userEntity;
    private TemplateEntity templateEntity;
    private Boolean isEdit;
}
