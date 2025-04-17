package com.mastringer.cc.wc.counters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ByteCounterTest {

    @Test
    void empty_string_input() throws Exception {
        String input = "";

        ByteCounter b = new ByteCounter();
        char[] charArray = input.toCharArray();
        b.update(charArray.length, charArray);
        long actual = b.getTotal();

        assertEquals(0, actual);
    }

    @Test
    void reads_number_of_bytes() throws Exception {
        String input = "123456";

        ByteCounter b = new ByteCounter();
        char[] charArray = input.toCharArray();
        b.update(charArray.length, charArray);
        long actual = b.getTotal();

        assertEquals(6, actual);
    }

    @Test
    void reads_number_of_special_character_bytes() throws Exception {
        String input = "ŭœ";

        ByteCounter b = new ByteCounter();
        char[] charArray = input.toCharArray();
        b.update(charArray.length, charArray);
        long actual = b.getTotal();

        assertEquals(4, actual);
    }

    @Test
    void reads_line_endings_windows() throws Exception {
        String input = "\r\n";

        ByteCounter b = new ByteCounter();
        char[] charArray = input.toCharArray();
        b.update(charArray.length, charArray);
        long actual = b.getTotal();

        assertEquals(2, actual);
    }
}
