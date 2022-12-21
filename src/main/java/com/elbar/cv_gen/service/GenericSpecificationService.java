package com.elbar.cv_gen.service;

import com.elbar.cv_gen.criteria.BaseCriteria;
import com.elbar.cv_gen.dto.GenericDTO;

import java.util.List;

public interface GenericSpecificationService<SC extends BaseCriteria, BC extends BaseCriteria, GD extends GenericDTO> {
    List<GD> list_with_search(SC criteria);

    List<GD> list_with_between(BC criteria);
}
