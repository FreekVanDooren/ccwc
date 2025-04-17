package com.mastringer.cc.wc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainIntegrationTest {
    private static final String inputFile = MainIntegrationTest.class.getClassLoader().getResource("integration_test.txt").getFile();

    @Test
    void count_bytes() throws Exception {
        var args = new String[]{"-c", inputFile};

        var actual = Main.process(args);
        
        Assertions.assertEquals(String.format("\t342190 %s\n", inputFile), actual);
    }

    @Test
    void count_lines() throws Exception {
        var args = new String[]{"-l", inputFile};

        var actual = Main.process(args);

        Assertions.assertEquals(String.format("\t7145 %s\n", inputFile), actual);
    }

    @Test
    void count_words() throws Exception {
        var args = new String[]{"-w", inputFile};

        var actual = Main.process(args);

        Assertions.assertEquals(String.format("\t58164 %s\n", inputFile), actual);
    }

    @Test
    void count_characters() throws Exception {
        var args = new String[]{"-m", inputFile};

        var actual = Main.process(args);

        Assertions.assertEquals(String.format("\t339292 %s\n", inputFile), actual);
    }

    @Test
    void count_no_flags() throws Exception {
        var args = new String[]{inputFile};

        var actual = Main.process(args);

        Assertions.assertEquals(String.format("\t7145\t58164\t342190 %s\n", inputFile), actual);
    }

    @Test
    void count_multi_flags() throws Exception {
        var args = new String[]{"-cl", inputFile};

        var actual = Main.process(args);

        Assertions.assertEquals(String.format("\t342190\t7145 %s\n", inputFile), actual);
    }
}
