package com.elbar.cv_gen.specification.project.template_rating;

import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.entity.project.template_rating.TemplateRatingEntity;
import com.elbar.cv_gen.specification.AbstractSpecification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TemplateRatingSearchSpecification extends AbstractSpecification<SearchCriteria, TemplateRatingEntity> {
    public TemplateRatingSearchSpecification(SearchCriteria criteria) {
        super(criteria);
    }

    @Override
    public Predicate toPredicate(Root<TemplateRatingEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return criteriaBuilder.greaterThan(
                    root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation().equalsIgnoreCase(">=")) {
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return criteriaBuilder.lessThan(
                    root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation().equalsIgnoreCase("<=")) {
            return criteriaBuilder.lessThanOrEqualTo(
                    root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation().equals(":")) {
            return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
        }
        return null;
    }
}
