package dev.rahulbaphana.filters;

import dev.rahulbaphana.filters.api.Filterable;

public class And implements Filterable {
    private final Filterable operation1;
    private final Filterable operation2;

    public And(Filterable operation1, Filterable operation2) {
        this.operation1 = operation1;
        this.operation2 = operation2;
    }

    @Override
    public boolean filter() {
        return operation1.filter() && operation2.filter();
    }
}
