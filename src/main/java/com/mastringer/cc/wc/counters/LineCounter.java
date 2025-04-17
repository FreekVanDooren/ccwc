package com.mastringer.cc.wc.counters;

import com.mastringer.cc.wc.Counter;

public class LineCounter implements Counter {
    private long total;

    @Override
    public void update(int charsRead, char[] buffer) {
        for (int i = 0; i < charsRead; i++) {
            char current = buffer[i];
            if (current == '\n') {
                total++;
            }
        }
    }

    @Override
    public long getTotal() {
        return total;
    }

}
