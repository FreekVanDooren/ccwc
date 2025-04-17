package com.mastringer.cc.wc.counters;

import com.mastringer.cc.wc.Counter;

public class CharacterCounter implements Counter {
    private long total = 0;

    @Override
    public void update(int charsRead, char[] buffer) {
        total += charsRead;
    }

    @Override
    public long getTotal() {
        return total;
    }
}
