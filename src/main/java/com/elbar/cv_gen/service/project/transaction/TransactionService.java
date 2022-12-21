package com.elbar.cv_gen.service.project.transaction;

import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.transaction.TransactionCriteria;
import com.elbar.cv_gen.dto.project.transaction.TransactionCreateDTO;
import com.elbar.cv_gen.dto.project.transaction.TransactionDetailDTO;
import com.elbar.cv_gen.dto.project.transaction.TransactionGetDTO;
import com.elbar.cv_gen.service.BaseService;
import com.elbar.cv_gen.service.GenericGLService;
import com.elbar.cv_gen.service.GenericSpecificationService;

public interface TransactionService extends GenericGLService<TransactionGetDTO, TransactionCriteria, Integer>,
        GenericSpecificationService<SearchCriteria, BetweenCriteria, TransactionGetDTO>, BaseService {

    void create(TransactionCreateDTO dto);

    void delete(Integer id);

    TransactionDetailDTO detail(Integer id);

    boolean existByTemplateIdAndUserId(Integer templateId, Integer userId);

}
