package com.elbar.cv_gen.specification.project.templateUser;

import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.entity.project.template_user.TemplateUserEntity;
import com.elbar.cv_gen.specification.AbstractSpecification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class TemplateUserBetweenSpecification extends AbstractSpecification<BetweenCriteria, TemplateUserEntity> {

    private final List<String> fields = List.of("templateId", "userId");

    public TemplateUserBetweenSpecification(BetweenCriteria criteria) {
        super(criteria);
    }

    @Override
    public Predicate toPredicate(Root<TemplateUserEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (!presentField(criteria.getKey())) {
            throw new RuntimeException("Field not found");
        }
        return criteriaBuilder.between(root.get(criteria.getKey()), criteria.getFrom(), criteria.getTo());
    }

    private boolean presentField(String key) {
        return fields.stream()
                .anyMatch(any -> any.equals(key));
    }
}
