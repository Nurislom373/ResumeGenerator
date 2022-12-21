package com.elbar.cv_gen.repository.project.template_rating;

import com.elbar.cv_gen.entity.project.template_rating.TemplateRatingEntity;
import com.elbar.cv_gen.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TemplateRatingRepository extends JpaRepository<TemplateRatingEntity, Integer>, JpaSpecificationExecutor<TemplateRatingEntity>, BaseRepository {
    Optional<TemplateRatingEntity> findByTemplateId(Integer templateId);
}
