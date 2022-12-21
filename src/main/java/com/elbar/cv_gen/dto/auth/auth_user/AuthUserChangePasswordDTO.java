package com.elbar.cv_gen.dto.auth.auth_user;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthUserChangePasswordDTO {
    @NotNull
    @Min(1)
    private Integer userId;
    @NotBlank
    @Size(min = 8, max = 120)
    private String oldPwd;
    @NotBlank
    @Size(min = 8, max = 120)
    private String newPwd;
}
