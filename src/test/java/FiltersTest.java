import dev.rahulbaphana.filters.api.Filters;
import org.junit.jupiter.api.Test;

import static dev.rahulbaphana.filters.api.Filters.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FiltersTest {
    @Test
    void shouldTestEqFilter() {
        assertTrue(eq(1, 1).apply());
        assertTrue(eq("abc", "abc").apply());
        assertTrue(eq(true, true).apply());

        assertFalse(eq("abc", "aBc").apply());
        assertFalse(eq(1, 2).apply());
        assertFalse(eq(true, false).apply());
    }

    @Test
    void shouldTestUnaryNotFilter() {
        assertFalse(not(eq("abc", "abc")).apply());
    }

    @Test
    void shouldTestAndFilter() {
        assertFalse(and(eq("abc", "abc"), eq(1, 2)).apply());
        assertFalse(and(eq("aBc", "abc"), eq(1, 1)).apply());
        assertFalse(and(eq("ABC", "abc"), eq(1, 2)).apply());
        assertTrue(and(eq("abc", "abc"), eq(1, 1)).apply());
    }

    @Test
    void shouldTestOrFilter() {
        assertTrue(Filters.or(eq("abc", "abc"), eq(1, 1)).apply());
        assertTrue(Filters.or(eq("aBc", "abc"), eq(1, 1)).apply());
        assertTrue(Filters.or(eq("abc", "abc"), eq(1, 2)).apply());
        assertFalse(Filters.or(eq("ABC", "abc"), eq(1, 2)).apply());
    }
}
