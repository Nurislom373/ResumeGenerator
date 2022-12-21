package com.elbar.cv_gen.dto.auth.auth_user;

import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.enums.auth.language.LanguagesEnum;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthUserUpdateDTO extends GenericDTO {
    @NotBlank
    @Size(min = 5, max = 120)
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 120)
    private String lastName;
    @NotBlank
    @Size(min = 11, max = 11)
    // TODO write annotation check phone number
    private String phone;
    @NotNull
    private LanguagesEnum language;
}
