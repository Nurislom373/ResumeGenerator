package com.elbar.cv_gen.service;

import com.elbar.cv_gen.criteria.BaseCriteria;
import com.elbar.cv_gen.dto.GenericDTO;

import java.io.Serializable;
import java.util.List;

public interface GenericGLService<GD extends GenericDTO, CR extends BaseCriteria, K extends Serializable> {
    GD get(K id);

    List<GD> list(CR criteria);
}
