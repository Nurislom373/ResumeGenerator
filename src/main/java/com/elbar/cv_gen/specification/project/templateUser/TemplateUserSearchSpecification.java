package com.elbar.cv_gen.specification.project.templateUser;

import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.entity.project.template_user.TemplateUserEntity;
import com.elbar.cv_gen.specification.AbstractSpecification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


public class TemplateUserSearchSpecification extends AbstractSpecification<SearchCriteria, TemplateUserEntity> {

    private final List<String> fields = List.of("isEdit", "templateId", "userId");

    public TemplateUserSearchSpecification(SearchCriteria criteria) {
        super(criteria);
    }

    @Override
    public Predicate toPredicate(Root<TemplateUserEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (!presentField(criteria.getKey())) {
            throw new RuntimeException("Field not found");
        }
        if (!criteria.getOperation().equals(":")) {
            throw new RuntimeException("only this operator works with this table! -> ':'");
        }
        if (criteria.getKey().equals("isEdit")) {
            return criteriaBuilder.equal(root.get(criteria.getKey()), Boolean.valueOf(criteria.getValue()));
        } else {
            return criteriaBuilder.equal(root.get(criteria.getKey()), Integer.valueOf(criteria.getValue()));
        }
    }

    private boolean presentField(String key) {
        return fields.stream()
                .anyMatch(any -> any.equals(key));
    }
}
