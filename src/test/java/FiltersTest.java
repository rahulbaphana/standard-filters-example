import dev.rahulbaphana.filters.api.Filters;
import org.junit.jupiter.api.Test;

import static dev.rahulbaphana.filters.api.Filters.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FiltersTest {
    @Test
    void shouldTestEqFilter() {
        assertTrue(eq(1, 1).filter());
        assertTrue(eq("abc", "abc").filter());
        assertTrue(eq(true, true).filter());

        assertFalse(eq("abc", "aBc").filter());
        assertFalse(eq(1, 2).filter());
        assertFalse(eq(true, false).filter());
    }

    @Test
    void shouldTestUnaryNotFilter() {
        assertFalse(not(eq("abc", "abc")).filter());
    }

    @Test
    void shouldTestAndFilter() {
        assertFalse(and(eq("abc", "abc"), eq(1, 2)).filter());
        assertFalse(and(eq("aBc", "abc"), eq(1, 1)).filter());
        assertFalse(and(eq("ABC", "abc"), eq(1, 2)).filter());
        assertTrue(and(eq("abc", "abc"), eq(1, 1)).filter());
    }

    @Test
    void shouldTestOrFilter() {
        assertTrue(Filters.or(eq("abc", "abc"), eq(1, 1)).filter());
        assertTrue(Filters.or(eq("aBc", "abc"), eq(1, 1)).filter());
        assertTrue(Filters.or(eq("abc", "abc"), eq(1, 2)).filter());
        assertFalse(Filters.or(eq("ABC", "abc"), eq(1, 2)).filter());
    }
}
