package com.mastringer.cc.wc.counters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    @Test
    void empty_string_input() throws Exception {
        String input = "";

        long actual = count(input);

        assertEquals(0, actual);
    }

    @Test
    void counts_a_word() throws Exception {
        String input = "one";

        long actual = count(input);

        assertEquals(1, actual);
    }

    @Test
    void counts_multiple_words() throws Exception {
        String input = "one\ntwo";

        long actual = count(input);

        assertEquals(2, actual);
    }

    @Test
    void counts_multiple_words_ignores_multiple_line_endings() throws Exception {
        String input = "one\n\ntwo";

        long actual = count(input);

        assertEquals(2, actual);
    }

    private long count(String input) {
        WordCounter w = new WordCounter();
        char[] charArray = input.toCharArray();
        w.update(charArray.length, charArray);
        return w.getTotal();
    }
}
