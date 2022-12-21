package com.elbar.cv_gen.specification.auth.auth_user;

import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.entity.auth.auth_user.AuthUserEntity;
import com.elbar.cv_gen.specification.AbstractSpecification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AuthUserBetweenSpecification extends AbstractSpecification<BetweenCriteria, AuthUserEntity> {

    public AuthUserBetweenSpecification(BetweenCriteria criteria) {
        super(criteria);
    }

    @Override
    public Predicate toPredicate(Root<AuthUserEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.between(root.get(criteria.getKey()), criteria.getFrom(), criteria.getTo());
    }
}
