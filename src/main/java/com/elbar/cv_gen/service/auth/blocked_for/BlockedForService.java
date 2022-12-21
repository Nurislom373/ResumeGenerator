package com.elbar.cv_gen.service.auth.blocked_for;

import com.elbar.cv_gen.criteria.auth.blocked_for.BlockedForCriteria;
import com.elbar.cv_gen.dto.auth.blocked_for.BlockedForCreateDTO;
import com.elbar.cv_gen.dto.auth.blocked_for.BlockedForGetDTO;
import com.elbar.cv_gen.service.BaseService;
import com.elbar.cv_gen.service.GenericGLService;

public interface BlockedForService extends GenericGLService<BlockedForGetDTO, BlockedForCriteria, Integer>, BaseService {

    void create(BlockedForCreateDTO dto);

    void delete(Integer id);

    Integer blockCodeGetMin(String code);
}
