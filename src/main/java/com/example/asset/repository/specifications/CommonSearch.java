package com.example.asset.repository.specifications;

import com.example.asset.repository.Filter.Filter;
import org.springframework.data.jpa.domain.Specification;

public abstract class CommonSearch<E> {

    public Specification<E> createSpecification(Filter input) {
        switch (input.getOperator()) {
            case LIKE:
                return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(input.getField()), "%" + input.getValue() + "%");
            case EQUALS:
                return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(input.getField()), "%" + input.getValue() + "%");
            case LESSTHAN:
                return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get(input.getField()), "%" + input.getValue() + "%");
            case LESSTHANOREQUAL:
                return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(input.getField()), "%" + input.getValue() + "%");
            default:
                throw new RuntimeException("Operation not supported yet");
        }
    }
}
