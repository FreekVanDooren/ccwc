package com.mastringer.cc.wc;

public interface Counter {
    void update(int charsRead, char[] buffer);

    long getTotal();
}
