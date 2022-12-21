package com.elbar.cv_gen.specification.auth.auth_user;

import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.entity.auth.auth_user.AuthUserEntity;
import com.elbar.cv_gen.enums.auth.language.LanguagesEnum;
import com.elbar.cv_gen.enums.auth.role.RolesEnum;
import com.elbar.cv_gen.enums.auth.status.StatusEnum;
import com.elbar.cv_gen.specification.AbstractSpecification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AuthUserSearchSpecification extends AbstractSpecification<SearchCriteria, AuthUserEntity> {

    public AuthUserSearchSpecification(SearchCriteria criteria) {
        super(criteria);
    }

    @Override
    public Predicate toPredicate(Root<AuthUserEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
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
            return switch (criteria.getKey()) {
                case "role" -> criteriaBuilder.equal(
                        root.get(criteria.getKey()), RolesEnum.getEqual(criteria.getValue()));
                case "status" -> criteriaBuilder.equal(
                        root.get(criteria.getKey()), StatusEnum.getEqual(criteria.getValue()));
                case "language" -> criteriaBuilder.equal(
                        root.get(criteria.getKey()), LanguagesEnum.getEqual(criteria.getValue()));
                default -> throw new IllegalStateException("Unexpected value: " + criteria.getKey());
            };
        }
        return null;
    }
}
