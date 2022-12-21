package com.elbar.cv_gen.entity.auth.auth_block;

import com.elbar.cv_gen.entity.Auditable;
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
@Table(name = "auth_block", schema = "auth")
public class AuthBlockEntity extends Auditable {
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "duration", nullable = false)
    private Instant duration;

    @Column(name = "blocked_for", nullable = false)
    private String blockedFor;

}
