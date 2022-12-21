package com.elbar.cv_gen.criteria.project.transaction;

import com.elbar.cv_gen.criteria.GenericCriteria;
import com.elbar.cv_gen.enums.project.transaction.TransactionFieldsEnum;
import lombok.Getter;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@ParameterObject
public class TransactionCriteria extends GenericCriteria {
    private TransactionFieldsEnum fieldsEnum;
}
