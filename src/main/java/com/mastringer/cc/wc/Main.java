package com.mastringer.cc.wc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print(process(args));
    }

    static String process(String[] args) throws Exception {
        CliArguments cliArguments = CliArguments.parse(args);

        List<Counter> counters = cliArguments.counters();
        try (
                var in = cliArguments.stream();
                var reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))
        ) {
            int charsRead;
            char[] buffer = new char[8192];
            while ((charsRead = reader.read(buffer)) != -1) {
                for (Counter counter : counters) {
                    counter.update(charsRead, buffer);
                }
            }
        }
        String printable = counters.stream().map(
                Counter::getTotal
        ).map(String::valueOf).collect(Collectors.joining("\t", "\t", " "));


        return String.format("""
                %s%s
                """, printable, cliArguments.fileName());
    }

}
