package com.elbar.cv_gen.dto.auth.auth_user;

import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.enums.auth.language.LanguagesEnum;
import com.elbar.cv_gen.enums.auth.status.StatusEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthUserGetDTO extends GenericDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private LanguagesEnum language;
    private StatusEnum status;
    private String imagePath;
}
