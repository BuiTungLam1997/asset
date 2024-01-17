package com.example.asset.repository.Filter;

public interface Builder {
   Builder buildField(String field);
   Builder buildOperator(Filter.QueryOperator operator);
   Builder buildValue(Object value);
   Filter build();

}
