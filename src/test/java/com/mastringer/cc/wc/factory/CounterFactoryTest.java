package com.mastringer.cc.wc.factory;

import com.mastringer.cc.wc.Counter;
import com.mastringer.cc.wc.counters.ByteCounter;
import com.mastringer.cc.wc.counters.CharacterCounter;
import com.mastringer.cc.wc.counters.LineCounter;
import com.mastringer.cc.wc.counters.WordCounter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CounterFactoryTest {
    @Test
    void c_flag() {
        List<Counter> actual = CounterFactory.getCounters("c");

        assertCountersEqual(actual, ByteCounter.class);
    }

    @Test
    void l_flag() {
        List<Counter> actual = CounterFactory.getCounters("l");

        assertCountersEqual(actual, LineCounter.class);
    }

    @Test
    void w_flag() {
        List<Counter> actual = CounterFactory.getCounters("w");

        assertCountersEqual(actual, WordCounter.class);
    }

    @Test
    void m_flag() {
        List<Counter> actual = CounterFactory.getCounters("m");

        assertCountersEqual(actual, CharacterCounter.class);
    }

    @Test
    void unknown_flag() {
        assertThrows(IllegalArgumentException.class, () -> CounterFactory.getCounters("u"), "Unknown flag: u");
    }

    @Test
    void no_flag() {
        List<Counter> actual = CounterFactory.getCounters("");

        assertCountersEqual(actual, LineCounter.class, WordCounter.class, ByteCounter.class);
    }

    @Test
    void multiple_flags() {
        List<Counter> actual = CounterFactory.getCounters("cm");

        assertCountersEqual(actual, ByteCounter.class, CharacterCounter.class);
    }

    @Test
    void multiple_flags_duplicate() {
        List<Counter> actual = CounterFactory.getCounters("cmc");

        assertCountersEqual(actual, ByteCounter.class, CharacterCounter.class);
    }

    @SafeVarargs
    private void assertCountersEqual(List<Counter> actual, Class<? extends Counter>... expected) {
        assertIterableEquals(List.of(expected),
                actual.stream().map(Counter::getClass).toList()
        );
    }
}
