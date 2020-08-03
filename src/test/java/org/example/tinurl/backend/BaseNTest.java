package org.example.tinurl.backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseNTest {

    static char[] charsOfBase63 = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '_'
    };

    static BaseN base63 = new BaseN(charsOfBase63, 10);

    @Test
    void shouldLongToBase63() {
        assertEquals("_________y", base63.longToBaseN(base63.getMaxLongValueInBase10() - 12L));
        assertEquals("________9y", base63.longToBaseN(base63.getMaxLongValueInBase10() - 63L - 12L));
        assertEquals("________xy", base63.longToBaseN(base63.getMaxLongValueInBase10() - 63L * 13L - 12L));
        assertEquals("_______x_y", base63.longToBaseN(base63.getMaxLongValueInBase10() - 63L * 63L * 13L - 12L));

        assertEquals("AAAAAAAAAA", base63.longToBaseN(0L));
        assertEquals("AAAAAAAAAB", base63.longToBaseN(1L));
        assertEquals("AAAAAAAABC", base63.longToBaseN(63L + 2L));
        assertEquals("AAAAAAEAAD", base63.longToBaseN(63L * 63L * 63L * 4L + 3L));

        assertEquals("__________", base63.longToBaseN(base63.getMaxLongValueInBase10()));
        assertThrows(IllegalArgumentException.class, () -> base63.longToBaseN(base63.getMaxLongValueInBase10() + 1L));
    }

    @Test
    void shouldBase63ToLong() {
        assertEquals(base63.getMaxLongValueInBase10(), base63.baseNToLong("__________"));
        assertEquals(base63.getMaxLongValueInBase10() - 12L, base63.baseNToLong("_________y"));
        assertEquals(base63.getMaxLongValueInBase10() - 63L - 12L, base63.baseNToLong("________9y"));
        assertEquals(base63.getMaxLongValueInBase10() - 63L * 13L - 12L, base63.baseNToLong("________xy"));
        assertEquals(base63.getMaxLongValueInBase10() - 63L * 63L * 13L - 12L, base63.baseNToLong("_______x_y"));

        assertEquals(0L, base63.baseNToLong("AAAAAAAAAA"));
        assertEquals(1L, base63.baseNToLong("AAAAAAAAAB"));
        assertEquals(1L, base63.baseNToLong("B"));
        assertEquals( 63L + 2L, base63.baseNToLong("AAAAAAAABC"));
        assertEquals( 63L * 63L * 63L * 4L + 3L, base63.baseNToLong("AAAAAAEAAD"));

        assertThrows(IllegalArgumentException.class, () -> base63.baseNToLong("AAAAA/AAAA"));
    }

    @Test
    void shouldMaxIntValueEqualsConstants() {
        long numberOfCombinations = BaseN.pow(63, 10);
        assertEquals(984930291881790849L, numberOfCombinations);
        assertEquals(numberOfCombinations -1, base63.getMaxLongValueInBase10());
    }

}