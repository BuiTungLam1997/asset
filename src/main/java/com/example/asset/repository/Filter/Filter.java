package com.example.asset.repository.Filter;

import lombok.Data;
import lombok.Getter;

public class Filter {
    private String field;
    private QueryOperator operator;
    private Object value;

    public Filter(String field, QueryOperator operator, Object value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    public Filter() {
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public QueryOperator getOperator() {
        return operator;
    }

    public void setOperator(QueryOperator operator) {
        this.operator = operator;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public enum QueryOperator {
        EQUALS,
        LIKE,
        IN,
        LESSTHAN,
        LESSTHANOREQUAL
    }
}

