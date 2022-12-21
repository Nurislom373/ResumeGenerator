package com.elbar.cv_gen.specification;

import com.elbar.cv_gen.criteria.BaseCriteria;
import com.elbar.cv_gen.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public abstract class AbstractSpecification<CR extends BaseCriteria, E extends BaseEntity> implements Specification<E>, BaseSpecification {
    protected final CR criteria;
}
