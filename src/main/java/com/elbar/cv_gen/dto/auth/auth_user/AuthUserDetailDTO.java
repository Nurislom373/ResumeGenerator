package com.elbar.cv_gen.dto.auth.auth_user;

import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.enums.auth.language.LanguagesEnum;
import com.elbar.cv_gen.enums.auth.role.RolesEnum;
import com.elbar.cv_gen.enums.auth.status.StatusEnum;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthUserDetailDTO extends GenericDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private LanguagesEnum language;
    private RolesEnum role;
    private StatusEnum status;
    private String imagePath;
    private Integer freeChance;
    private Instant lastLoginAt;
    private Integer loginTryCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
