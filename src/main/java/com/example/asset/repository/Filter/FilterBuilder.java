package com.example.asset.repository.Filter;

public class FilterBuilder implements Builder {

    private String field;
    private Filter.QueryOperator operator;
    private Object value;

    @Override
    public Builder buildField(String field) {
        this.field = field;
        return this;
    }

    @Override
    public Builder buildOperator(Filter.QueryOperator operator) {
        this.operator = operator;
        return this;
    }

    @Override
    public Builder buildValue(Object value) {
        this.value = value;
        return this;
    }

    @Override
    public Filter build() {
        return new Filter(field, operator, value);
    }
}
