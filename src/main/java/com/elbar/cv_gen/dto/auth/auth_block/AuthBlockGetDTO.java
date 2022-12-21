package com.elbar.cv_gen.dto.auth.auth_block;

import com.elbar.cv_gen.dto.GenericDTO;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthBlockGetDTO extends GenericDTO {
    private Integer userId;
    private Instant duration;
    private String blockedFor;
}
