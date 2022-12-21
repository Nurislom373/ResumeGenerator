package com.elbar.cv_gen.entity.auth.auth_user;

import com.elbar.cv_gen.entity.Auditable;
import com.elbar.cv_gen.enums.auth.language.LanguagesEnum;
import com.elbar.cv_gen.enums.auth.role.RolesEnum;
import com.elbar.cv_gen.enums.auth.status.StatusEnum;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_deleted = false")
@Table(name = "auth_user", schema = "auth")
public class AuthUserEntity extends Auditable {
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "language", nullable = false)
    private LanguagesEnum language;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private RolesEnum role;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusEnum status;

    @Column(name = "image_path", columnDefinition = "text")
    private String imagePath;

    @Column(name = "download_count", nullable = false)
    private Integer downloadCount;

    @Column(name = "last_login_at")
    private Instant lastLoginAt;

    @Column(name = "login_try_count")
    private Integer loginTryCount;

}
