package com.elbar.cv_gen.dto.auth.auth_token;

import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.enums.auth.token.TokenType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthTokenGetDTO extends GenericDTO {
    private Integer userId;
    private String token;
    private TokenType type;
}
