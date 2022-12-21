package com.elbar.cv_gen.service.project.template_user;

import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.template_user.TemplateUserCriteria;
import com.elbar.cv_gen.dto.project.template_user.TemplateUserCreateDTO;
import com.elbar.cv_gen.dto.project.template_user.TemplateUserDetailDTO;
import com.elbar.cv_gen.dto.project.template_user.TemplateUserGetDTO;
import com.elbar.cv_gen.dto.project.template_user.TemplateUserUpdateDTO;
import com.elbar.cv_gen.service.BaseService;
import com.elbar.cv_gen.service.GenericCUDService;
import com.elbar.cv_gen.service.GenericGLService;
import com.elbar.cv_gen.service.GenericSpecificationService;

public interface TemplateUserService extends GenericCUDService<TemplateUserCreateDTO, TemplateUserUpdateDTO, Integer>,
        GenericGLService<TemplateUserGetDTO, TemplateUserCriteria, Integer>,
        GenericSpecificationService<SearchCriteria, BetweenCriteria, TemplateUserGetDTO>, BaseService {

    TemplateUserDetailDTO detail(Integer id);

}
