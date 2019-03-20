package dev.rahulbaphana.filters;

import dev.rahulbaphana.filters.api.Filterable;

public class OrFilter implements Filterable {
    private final Filterable operation1;
    private final Filterable operation2;

    public OrFilter(Filterable operation1, Filterable operation2) {
        this.operation1 = operation1;
        this.operation2 = operation2;
    }

    @Override
    public boolean apply() {
        return operation1.apply() || operation2.apply();
    }
}
