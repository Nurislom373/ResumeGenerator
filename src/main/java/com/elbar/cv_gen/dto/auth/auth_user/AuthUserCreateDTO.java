package com.elbar.cv_gen.dto.auth.auth_user;

import com.elbar.cv_gen.dto.BaseDTO;
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
public class AuthUserCreateDTO implements BaseDTO {
    @NotBlank
    @Size(min = 3, max = 120)
    private String firstName;
    @NotBlank
    @Size(min = 3, max = 120)
    private String lastName;
    @NotBlank
    @Size(min = 13, max = 13)
    // TODO write annotation check phone number
    private String phone;
    @NotBlank
    @Size(min = 8, max = 120)
    private String password;
    @NotNull
    private LanguagesEnum language;
    private String imagePath;
}
