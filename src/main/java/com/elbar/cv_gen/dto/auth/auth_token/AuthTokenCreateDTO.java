package com.elbar.cv_gen.dto.auth.auth_token;

import com.elbar.cv_gen.dto.BaseDTO;
import com.elbar.cv_gen.enums.auth.token.TokenType;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthTokenCreateDTO implements BaseDTO {
    @NotNull
    @Min(1)
    private Integer userId;
    @NotNull
    @Min(1)
    private Integer minDuration;
    @NotBlank
    private String token;
    @NotNull
    private TokenType type;
}
