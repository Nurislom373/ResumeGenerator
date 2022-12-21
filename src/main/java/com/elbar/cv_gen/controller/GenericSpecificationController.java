package com.elbar.cv_gen.controller;

import com.elbar.cv_gen.criteria.GenericCriteria;
import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.response.Data;
import com.elbar.cv_gen.specification.BaseSpecification;
import com.elbar.cv_gen.utils.BaseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

public interface GenericSpecificationController<SC extends GenericCriteria, BC extends GenericCriteria, GD extends GenericDTO> {
    @RequestMapping(value = BaseUtils.LIST_WITH_SEARCH_PATH, method = RequestMethod.GET)
    ResponseEntity<Data<List<GD>>> list_with_search(@Valid SC criteria);

    @RequestMapping(value = BaseUtils.LIST_WITH_BETWEEN_PATH, method = RequestMethod.GET)
    ResponseEntity<Data<List<GD>>> list_with_between(@Valid BC criteria);
}
