package com.elbar.cv_gen.specification.project.transaction;

import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.entity.project.transaction.TransactionEntity;
import com.elbar.cv_gen.exception.exception.CriteriaDoestFitException;
import com.elbar.cv_gen.specification.AbstractSpecification;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

public class TransactionSpecification {

    public static class SearchPredicate extends AbstractSpecification<SearchCriteria, TransactionEntity> {

        private final List<String> fields = List.of("amount", "cardId", "templateId", "userId");

        public SearchPredicate(SearchCriteria criteria) {
            super(criteria);
        }

        @Override
        public Predicate toPredicate(Root<TransactionEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (!presentField(criteria.getKey())) {
                throw new RuntimeException("Field not found");
            }
            if (!hasNum(criteria.getValue())) {
                throw new RuntimeException("isn't numeric value");
            }
            if (criteria.getKey().equals("amount")) {
                if (criteria.getOperation().equalsIgnoreCase(">")) {
                    return criteriaBuilder.greaterThan(
                            root.get(criteria.getKey()), Long.valueOf(criteria.getValue()));
                } else if (criteria.getOperation().equalsIgnoreCase(">=")) {
                    return criteriaBuilder.greaterThanOrEqualTo(
                            root.get(criteria.getKey()), Long.valueOf(criteria.getValue()));
                } else if (criteria.getOperation().equalsIgnoreCase("<")) {
                    return criteriaBuilder.lessThan(
                            root.get(criteria.getKey()), Long.valueOf(criteria.getValue()));
                } else if (criteria.getOperation().equalsIgnoreCase("<=")) {
                    return criteriaBuilder.lessThanOrEqualTo(
                            root.get(criteria.getKey()), Long.valueOf(criteria.getValue()));
                } else if (criteria.getOperation().equals(":")) {
                    return criteriaBuilder.equal(root.get(criteria.getKey()), Long.valueOf(criteria.getValue()));
                }
            } else {
                if (criteria.getOperation().equals(":")) {
                    return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
                } else {
                    throw new CriteriaDoestFitException("only equal operation works for these fields!");
                }
            }
            return null;
        }

        private boolean hasNum(String value) {
            return StringUtils.isNumeric(value);
        }

        private boolean presentField(String key) {
            return fields.stream()
                    .anyMatch(any -> any.equals(key));
        }
    }

    public static class BetweenPredicate extends AbstractSpecification<BetweenCriteria, TransactionEntity> {

        public BetweenPredicate(BetweenCriteria criteria) {
            super(criteria);
        }

        @Override
        public Predicate toPredicate(Root<TransactionEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            checkObj(criteria);
            if (!criteria.getKey().equals("amount")) {
                throw new CriteriaDoestFitException("only the amount field can be searched between!");
            }
            return criteriaBuilder.between(root.get(criteria.getKey()), criteria.getFrom(), criteria.getTo());
        }

        private void checkObj(BetweenCriteria criteria) {
            if (Objects.isNull(criteria)) {
                throw new CriteriaDoestFitException("criteria is null!");
            }
        }
    }
}
