package com.elbar.cv_gen.criteria;

import com.elbar.cv_gen.specification.BaseSpecification;
import lombok.*;
import org.springdoc.api.annotations.ParameterObject;

@Getter
@Setter
@ToString
@ParameterObject
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria extends GenericCriteria implements BaseSpecification {
    private String key;
    private String operation;
    private String value;
}
