package com.elbar.cv_gen.dto.project.transaction;

import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.entity.auth.auth_card.AuthCardEntity;
import com.elbar.cv_gen.entity.auth.auth_user.AuthUserEntity;
import com.elbar.cv_gen.entity.project.template.TemplateEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionDetailDTO extends GenericDTO {
    private TemplateEntity template;
    private AuthUserEntity user;
    private AuthCardEntity card;
    private Long amount;
}
