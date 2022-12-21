package com.elbar.cv_gen.repository.project.template_user;

import com.elbar.cv_gen.entity.project.template_user.TemplateUserEntity;
import com.elbar.cv_gen.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateUserRepository extends JpaRepository<TemplateUserEntity, Integer>,
        JpaSpecificationExecutor<TemplateUserEntity>, BaseRepository {

    boolean existsByUserIdAndTemplateId(Integer userId, Integer templateId);
}
