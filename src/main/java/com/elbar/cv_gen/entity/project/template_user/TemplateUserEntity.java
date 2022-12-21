package com.elbar.cv_gen.entity.project.template_user;

import com.elbar.cv_gen.entity.Auditable;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_deleted = false")
@Table(name = "template_user", schema = "project")
public class TemplateUserEntity extends Auditable {
    @Column(name = "template_id", nullable = false)
    private Integer templateId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "is_edit", nullable = false)
    private Boolean isEdit;
}
