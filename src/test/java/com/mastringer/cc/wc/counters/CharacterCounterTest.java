package com.mastringer.cc.wc.counters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterCounterTest {

    @Test
    void empty_string_input() throws Exception {
        String input = "";

        long actual = count(input);

        assertEquals(0, actual);
    }

    @Test
    void counts_a_character() throws Exception {
        String input = "o";

        long actual = count(input);

        assertEquals(1, actual);
    }

    @Test
    void counts_multiple_words_unix() throws Exception {
        String input = "on\n\te";

        long actual = count(input);

        assertEquals(5, actual);
    }

    @Test
    void counts_multiple_words_windows() throws Exception {
        String input = "on\r\n\te";

        long actual = count(input);

        assertEquals(6, actual);
    }

    @Test
    void counts_special_characters() throws Exception {
        String input = "ŭœ";

        long actual = count(input);

        assertEquals(2, actual);
    }

    private long count(String input) {
        CharacterCounter c = new CharacterCounter();
        char[] charArray = input.toCharArray();
        c.update(charArray.length, charArray);
        return c.getTotal();
    }
}
