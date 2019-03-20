package dev.rahulbaphana.filters.api;

import dev.rahulbaphana.filters.*;

public enum Filters {
    ;

    public static <T extends Comparable> Filterable eq(T op1, T op2) {
        return new Equal<>(op1, op2);
    }

    public static Filterable not(Filterable filterToInvert) {
        return new Not(filterToInvert);
    }

    public static Filterable and(Filterable operation1, Filterable operation2) {
        return new And(operation1, operation2);
    }

    public static Filterable or(Filterable operation1, Filterable operation2) {
        return new Or(operation1, operation2);
    }
}
