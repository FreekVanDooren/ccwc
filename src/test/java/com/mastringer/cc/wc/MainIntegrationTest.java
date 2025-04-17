package com.mastringer.cc.wc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainIntegrationTest {
    private static final String inputFile = MainIntegrationTest.class.getClassLoader().getResource("integration_test.txt").getFile();

    @Test
    void count_bytes() throws Exception {
        var args = new String[]{"-c", inputFile};

        var actual = Main.process(args);

        assertOutputEquals("\t342190 %s\n", actual);
    }

    @Test
    void count_lines() throws Exception {
        var args = new String[]{"-l", inputFile};

        var actual = Main.process(args);

        assertOutputEquals("\t7145 %s\n", actual);
    }

    @Test
    void count_words() throws Exception {
        var args = new String[]{"-w", inputFile};

        var actual = Main.process(args);

        assertOutputEquals("\t58164 %s\n", actual);
    }

    @Test
    void count_characters() throws Exception {
        var args = new String[]{"-m", inputFile};

        var actual = Main.process(args);

        assertOutputEquals("\t339292 %s\n", actual);
    }

    @Test
    void count_no_flags() throws Exception {
        var args = new String[]{inputFile};

        var actual = Main.process(args);

        assertOutputEquals("\t7145\t58164\t342190 %s\n", actual);
    }

    @Test
    void count_multi_flags() throws Exception {
        var args = new String[]{"-cl", inputFile};

        var actual = Main.process(args);

        assertOutputEquals("\t342190\t7145 %s\n", actual);
    }

    private static void assertOutputEquals(String expected, String actual) {
        assertEquals(String.format(expected, inputFile), actual);
    }
}
