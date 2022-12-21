package com.elbar.cv_gen.repository.project.template_save;

import com.elbar.cv_gen.entity.project.template_save.TemplateSaveEntity;
import com.elbar.cv_gen.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateSaveRepository extends JpaRepository<TemplateSaveEntity, Integer>, BaseRepository {

    boolean existsByUserIdAndTemplateId(Integer userId, Integer templateId);

}
