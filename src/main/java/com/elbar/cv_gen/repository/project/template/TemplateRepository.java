package com.elbar.cv_gen.repository.project.template;

import com.elbar.cv_gen.entity.project.template.TemplateEntity;
import com.elbar.cv_gen.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TemplateRepository extends JpaRepository<TemplateEntity, Integer>, JpaSpecificationExecutor<TemplateEntity>, BaseRepository {
    @Query("from TemplateEntity where id = ?1 and isDeleted = false")
    boolean existsByIdAndDeletedFalse(Integer id);
    Optional<TemplateEntity> findByTitle(String title);
}
