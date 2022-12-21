package com.elbar.cv_gen.service.auth.auth_block;

import com.elbar.cv_gen.criteria.auth.auth_block.AuthBlockCriteria;
import com.elbar.cv_gen.dto.auth.auth_block.AuthBlockCreateDTO;
import com.elbar.cv_gen.dto.auth.auth_block.AuthBlockDetailDTO;
import com.elbar.cv_gen.dto.auth.auth_block.AuthBlockGetDTO;
import com.elbar.cv_gen.service.BaseService;
import com.elbar.cv_gen.service.GenericGLService;

public interface AuthBlockService extends GenericGLService<AuthBlockGetDTO, AuthBlockCriteria, Integer>, BaseService {

    void create(AuthBlockCreateDTO dto);

    void delete(Integer id);

    AuthBlockDetailDTO detail(Integer id);

    boolean userIdBlocked(Integer id);

}
