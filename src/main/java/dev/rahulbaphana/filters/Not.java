package dev.rahulbaphana.filters;

import dev.rahulbaphana.filters.api.Filterable;

public class Not implements Filterable {
    private Filterable filterToInvert;

    public Not(Filterable filterToInvert) {
        this.filterToInvert = filterToInvert;
    }

    @Override
    public boolean filter() {
        return !filterToInvert.filter();
    }
}
