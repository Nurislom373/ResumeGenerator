package com.elbar.cv_gen.controller;

import com.elbar.cv_gen.criteria.BaseCriteria;
import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

public interface GenericGLController<GD extends GenericDTO, CR extends BaseCriteria, K extends Serializable> {
    @RequestMapping(value = BaseUtils.GET_PATH, method = RequestMethod.GET)
    ResponseEntity<Data<GD>> get(@PathVariable K id);

    @RequestMapping(value = BaseUtils.LIST_PATH, method = RequestMethod.GET)
    ResponseEntity<Data<List<GD>>> list(@Valid CR criteria);
}
