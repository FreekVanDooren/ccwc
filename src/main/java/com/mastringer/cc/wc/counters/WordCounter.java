package com.mastringer.cc.wc.counters;

import com.mastringer.cc.wc.Counter;

import java.util.Arrays;

public class WordCounter implements Counter {
    private StringBuilder currentLine = new StringBuilder();
    private long total = 0;

    @Override
    public void update(int charsRead, char[] buffer) {
        for (int i = 0; i < charsRead; i++) {
            char current = buffer[i];
            if (current != '\n') {
                currentLine.append(current);
            } else {
                updateTotal();
            }
        }
    }

    @Override
    public long getTotal() {
        updateTotal();
        return total;
    }

    private void updateTotal() {
        if (!currentLine.isEmpty()) {
            total += Arrays.stream(currentLine.toString().split("\\s+")).filter(s -> !s.isEmpty()).count();
            currentLine = new StringBuilder();
        }
    }
}
