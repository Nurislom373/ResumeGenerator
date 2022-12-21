package com.elbar.cv_gen.specification.project.category;

import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.entity.project.category.CategoryEntity;
import com.elbar.cv_gen.specification.AbstractSpecification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CategoryBetweenSpecification extends AbstractSpecification<BetweenCriteria, CategoryEntity> {
    public CategoryBetweenSpecification(BetweenCriteria criteria) {
        super(criteria);
    }

    @Override
    public Predicate toPredicate(Root<CategoryEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.between(root.get(criteria.getKey()), criteria.getFrom(), criteria.getTo());
    }
}
