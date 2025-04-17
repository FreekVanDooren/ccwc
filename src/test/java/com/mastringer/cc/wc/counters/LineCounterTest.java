package com.mastringer.cc.wc.counters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LineCounterTest {

    @Test
    void empty_string_input() throws Exception {
        String input = "";

        long actual = count(input);

        assertEquals(0, actual);
    }

    @Test
    void counts_a_line() throws Exception {
        String input = "\n";

        long actual = count(input);

        assertEquals(1, actual);
    }

    @Test
    void counts_multiple_lines() throws Exception {
        String input = "\n\n";

        long actual = count(input);

        assertEquals(2, actual);
    }

    private long count(String input) {
        LineCounter l = new LineCounter();
        char[] charArray = input.toCharArray();
        l.update(charArray.length, charArray);
        return l.getTotal();
    }
}
