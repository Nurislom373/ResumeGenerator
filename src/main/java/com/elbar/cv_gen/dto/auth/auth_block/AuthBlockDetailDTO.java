package com.elbar.cv_gen.dto.auth.auth_block;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthBlockDetailDTO extends GenericDTO {
    private Integer userId;
    private Instant duration;
    private String blockedFor;
    private LocalDateTime createdAt;
}
