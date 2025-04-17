package com.mastringer.cc.wc.factory;

import com.mastringer.cc.wc.Counter;
import com.mastringer.cc.wc.counters.ByteCounter;
import com.mastringer.cc.wc.counters.CharacterCounter;
import com.mastringer.cc.wc.counters.LineCounter;
import com.mastringer.cc.wc.counters.WordCounter;

import java.util.List;

public class CounterFactory {
    public static List<Counter> getCounters(String flag) {
        if (flag.isEmpty()) {
            return List.of(new LineCounter(), new WordCounter(), new ByteCounter());
        }
        return flag.chars().distinct().mapToObj(f ->
                switch (f) {
                    case 'c' -> new ByteCounter();
                    case 'l' -> new LineCounter();
                    case 'w' -> new WordCounter();
                    case 'm' -> new CharacterCounter();
                    default -> throw new IllegalArgumentException("Unknown flag: " + f);
                }
        ).toList();
    }
}
