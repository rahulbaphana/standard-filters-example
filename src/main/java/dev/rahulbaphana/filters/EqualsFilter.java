package dev.rahulbaphana.filters;

import dev.rahulbaphana.filters.api.Filterable;

public class EqualsFilter<T extends Comparable> implements Filterable {
    private final T op1;
    private final T op2;

    public EqualsFilter(T op1, T op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public boolean apply() {
        return op1.equals(op2);
    }
}
