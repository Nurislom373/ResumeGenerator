package com.elbar.cv_gen.entity.project.category;

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
@Table(name = "category", schema = "project")
public class CategoryEntity extends Auditable {
    @Column(name = "title", nullable = false, unique = true, length = 150)
    private String title;

    @Column(name = "description", nullable = false, length = 300)
    private String description;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;
}
