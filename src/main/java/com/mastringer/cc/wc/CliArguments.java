package com.mastringer.cc.wc;

import com.mastringer.cc.wc.factory.CounterFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public record CliArguments(List<Counter> counters, Path path) {
    static CliArguments parse(String[] args) {
        String flag = "";
        Path path = null;
        for (var arg : args) {
            if (arg.startsWith("-")) {
                flag = arg.substring(1);
            } else {
                path = Path.of(arg);
            }
        }
        return new CliArguments(CounterFactory.getCounters(flag), path);
    }

    public InputStream stream() throws IOException {
        if (path == null) {
            return System.in;
        }
        return Files.newInputStream(path);
    }

    public String fileName() {
        if (path == null) {
            return "";
        }
        return path.toString();
    }
}
