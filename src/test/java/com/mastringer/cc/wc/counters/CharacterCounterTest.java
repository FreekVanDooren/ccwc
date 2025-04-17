package com.mastringer.cc.wc.counters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterCounterTest {

    @Test
    void empty_string_input() throws Exception {
        String input = "";

        CharacterCounter c = new CharacterCounter();
        char[] charArray = input.toCharArray();
        c.update(charArray.length, charArray);
        long actual = c.getTotal();

        assertEquals(0, actual);
    }

    @Test
    void counts_a_character() throws Exception {
        String input = "o";

        CharacterCounter c = new CharacterCounter();
        char[] charArray = input.toCharArray();
        c.update(charArray.length, charArray);
        long actual = c.getTotal();

        assertEquals(1, actual);
    }

    @Test
    void counts_multiple_words_unix() throws Exception {
        String input = "on\n\te";

        CharacterCounter c = new CharacterCounter();
        char[] charArray = input.toCharArray();
        c.update(charArray.length, charArray);
        long actual = c.getTotal();

        assertEquals(5, actual);
    }

    @Test
    void counts_multiple_words_windows() throws Exception {
        String input = "on\r\n\te";

        CharacterCounter c = new CharacterCounter();
        char[] charArray = input.toCharArray();
        c.update(charArray.length, charArray);
        long actual = c.getTotal();

        assertEquals(6, actual);
    }

    @Test
    void counts_special_characters() throws Exception {
        String input = "ŭœ";

        CharacterCounter c = new CharacterCounter();
        char[] charArray = input.toCharArray();
        c.update(charArray.length, charArray);
        long actual = c.getTotal();

        assertEquals(2, actual);
    }
}
