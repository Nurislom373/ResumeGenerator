package com.elbar.cv_gen.entity.project.template;

import com.elbar.cv_gen.entity.Auditable;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_deleted = false")
@Table(name = "template", schema = "project")
public class TemplateEntity extends Auditable {
    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "html", nullable = false, columnDefinition = "text")
    private String html;

    @Column(name = "fields", nullable = false, columnDefinition = "text")
    private String fields;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Column(name = "image_path", nullable = false)
    private String imagePath;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "download_count", nullable = false)
    private Integer downloadCount;

    @Column(name = "is_premium", nullable = false)
    private Boolean isPremium = false;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;
}
