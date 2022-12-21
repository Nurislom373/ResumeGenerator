package com.elbar.cv_gen.specification.project.template_rating;

import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.entity.project.template_rating.TemplateRatingEntity;
import com.elbar.cv_gen.specification.AbstractSpecification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TemplateRatingBetweenSpecification extends AbstractSpecification<BetweenCriteria, TemplateRatingEntity> {
    public TemplateRatingBetweenSpecification(BetweenCriteria criteria) {
        super(criteria);
    }

    @Override
    public Predicate toPredicate(Root<TemplateRatingEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.between(root.get(criteria.getKey()), criteria.getFrom(), criteria.getTo());
    }
}
