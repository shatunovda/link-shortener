package org.example.tinurl.backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Base63Test {

    @Test
    void shouldLongToBase63() {
        assertEquals("_________y", Base63.longToBase63(Base63.MAX_LONG_VALUE_FOR_BASE_63 - 12L));
        assertEquals("________9y", Base63.longToBase63(Base63.MAX_LONG_VALUE_FOR_BASE_63 - 63L - 12L));
        assertEquals("________xy", Base63.longToBase63(Base63.MAX_LONG_VALUE_FOR_BASE_63 - 63L * 13L - 12L));
        assertEquals("_______x_y", Base63.longToBase63(Base63.MAX_LONG_VALUE_FOR_BASE_63 - 63L * 63L * 13L - 12L));

        assertEquals("AAAAAAAAAA", Base63.longToBase63(0L));
        assertEquals("AAAAAAAAAB", Base63.longToBase63(1L));
        assertEquals("AAAAAAAABC", Base63.longToBase63(63L + 2L));
        assertEquals("AAAAAAEAAD", Base63.longToBase63(63L * 63L * 63L * 4L + 3L));

        assertEquals("__________", Base63.longToBase63(Base63.MAX_LONG_VALUE_FOR_BASE_63));
        assertThrows(IllegalArgumentException.class, () -> Base63.longToBase63(Base63.MAX_LONG_VALUE_FOR_BASE_63 + 1L));
    }

    @Test
    void shouldBase63ToLong() {
        assertEquals(Base63.MAX_LONG_VALUE_FOR_BASE_63, Base63.base63ToLong("__________"));
        assertEquals(Base63.MAX_LONG_VALUE_FOR_BASE_63 - 12L, Base63.base63ToLong("_________y"));
        assertEquals(Base63.MAX_LONG_VALUE_FOR_BASE_63 - 63L - 12L, Base63.base63ToLong("________9y"));
        assertEquals(Base63.MAX_LONG_VALUE_FOR_BASE_63 - 63L * 13L - 12L, Base63.base63ToLong("________xy"));
        assertEquals(Base63.MAX_LONG_VALUE_FOR_BASE_63 - 63L * 63L * 13L - 12L, Base63.base63ToLong("_______x_y"));

        assertEquals(0L, Base63.base63ToLong("AAAAAAAAAA"));
        assertEquals(1L, Base63.base63ToLong("AAAAAAAAAB"));
        assertEquals(1L, Base63.base63ToLong("B"));
        assertEquals( 63L + 2L, Base63.base63ToLong("AAAAAAAABC"));
        assertEquals( 63L * 63L * 63L * 4L + 3L, Base63.base63ToLong("AAAAAAEAAD"));

        assertThrows(IllegalArgumentException.class, () -> Base63.base63ToLong("AAAAA/AAAA"));
    }

    @Test
    void shouldMaxIntValueEqualsConstants() {
        long numberOfCombinations = Base63.pow(63, 10);
        assertEquals(984930291881790849L, numberOfCombinations);
        assertEquals(numberOfCombinations -1, Base63.MAX_LONG_VALUE_FOR_BASE_63);
    }

}