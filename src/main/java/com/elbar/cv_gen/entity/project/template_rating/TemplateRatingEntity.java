package com.elbar.cv_gen.entity.project.template_rating;

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
@Table(name = "template_rating", schema = "project")
public class TemplateRatingEntity extends Auditable {
    @Column(name = "star_count", nullable = false)
    private Byte starCount = 0;

    @Column(name = "buy_count", nullable = false)
    private Integer buyCount = 0;

    @Column(name = "template_id", nullable = false, unique = true)
    private Integer templateId;
}
