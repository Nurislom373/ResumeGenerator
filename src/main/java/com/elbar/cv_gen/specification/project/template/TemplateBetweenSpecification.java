package com.elbar.cv_gen.specification.project.template;

import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.entity.project.template.TemplateEntity;
import com.elbar.cv_gen.specification.AbstractSpecification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TemplateBetweenSpecification extends AbstractSpecification<BetweenCriteria, TemplateEntity> {
    public TemplateBetweenSpecification(BetweenCriteria criteria) {
        super(criteria);
    }

    @Override
    public Predicate toPredicate(Root<TemplateEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.between(root.get(criteria.getKey()), criteria.getFrom(), criteria.getTo());
    }
}
