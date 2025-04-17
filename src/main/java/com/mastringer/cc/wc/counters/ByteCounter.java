package com.mastringer.cc.wc.counters;

import com.mastringer.cc.wc.Counter;

public class ByteCounter implements Counter {
    private long total = 0;

    @Override
    public void update(int charsRead, char[] buffer) {
        byte[] bytes = String.valueOf(buffer, 0, charsRead).getBytes();
        total += bytes.length;
    }

    @Override
    public long getTotal() {
        return total;
    }
}
