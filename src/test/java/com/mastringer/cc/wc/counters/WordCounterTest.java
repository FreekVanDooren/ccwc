package com.mastringer.cc.wc.counters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    @Test
    void empty_string_input() throws Exception {
        String input = "";

        WordCounter w = new WordCounter();
        char[] charArray = input.toCharArray();
        w.update(charArray.length, charArray);
        long actual = w.getTotal();

        assertEquals(0, actual);
    }

    @Test
    void counts_a_word() throws Exception {
        String input = "one";

        WordCounter w = new WordCounter();
        char[] charArray = input.toCharArray();
        w.update(charArray.length, charArray);
        long actual = w.getTotal();

        assertEquals(1, actual);
    }

    @Test
    void counts_multiple_words() throws Exception {
        String input = "one\ntwo";

        WordCounter w = new WordCounter();
        char[] charArray = input.toCharArray();
        w.update(charArray.length, charArray);
        long actual = w.getTotal();

        assertEquals(2, actual);
    }

    @Test
    void counts_multiple_words_ignores_multiple_line_endings() throws Exception {
        String input = "one\n\ntwo";

        WordCounter w = new WordCounter();
        char[] charArray = input.toCharArray();
        w.update(charArray.length, charArray);
        long actual = w.getTotal();

        assertEquals(2, actual);
    }
}
