package com.elbar.cv_gen.dto.auth.auth_token;

import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.enums.auth.token.TokenType;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthTokenDetailDTO extends GenericDTO {
    private Integer userId;
    private Instant duration;
    private String token;
    private TokenType type;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
