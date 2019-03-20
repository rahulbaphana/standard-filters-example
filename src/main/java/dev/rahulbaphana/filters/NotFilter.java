package dev.rahulbaphana.filters;

import dev.rahulbaphana.filters.api.Filterable;

public class NotFilter implements Filterable {
    private Filterable filterToInvert;

    public NotFilter(Filterable filterToInvert) {
        this.filterToInvert = filterToInvert;
    }

    @Override
    public boolean filter() {
        return !filterToInvert.filter();
    }
}
