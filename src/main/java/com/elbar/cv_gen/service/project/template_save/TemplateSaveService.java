package com.elbar.cv_gen.service.project.template_save;

import com.elbar.cv_gen.criteria.project.template_save.TemplateSaveCriteria;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveCreateDTO;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveDetailDTO;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveGetDTO;
import com.elbar.cv_gen.dto.project.template_save.TemplateSaveUpdateDTO;
import com.elbar.cv_gen.service.BaseService;
import com.elbar.cv_gen.service.GenericCUDService;
import com.elbar.cv_gen.service.GenericGLService;

public interface TemplateSaveService extends GenericGLService<TemplateSaveGetDTO, TemplateSaveCriteria, Integer>,
        BaseService {

    void create(TemplateSaveCreateDTO dto);

    void delete(Integer id);

    TemplateSaveDetailDTO detail(Integer id);
}
