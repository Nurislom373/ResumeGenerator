package com.elbar.cv_gen.dto.auth.auth_user;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthUserRequestDTO {
    @NotBlank
    private String phone;
    @NotBlank
    private String password;
}
