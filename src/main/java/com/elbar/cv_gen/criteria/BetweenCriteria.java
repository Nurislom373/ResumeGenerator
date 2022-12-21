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
public class BetweenCriteria extends GenericCriteria implements BaseSpecification {
    private String key;
    private Integer from;
    private Integer to;
}
