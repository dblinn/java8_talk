package com.vmt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

public class e_Streams {
    // LAZY EVALUATION!!!!
    // DEBUGGER EXAMPLE???

    //  Stream operations are either intermediate or terminal.
    // While terminal operations return a result of a certain type,
    // intermediate operations return the stream itself so you can
    // chain multiple method calls in a row.
    List<String> strings = Arrays.asList(
        "ddd2", "aaa2", "bbb1", "aaa1", "bbb3", "ccc", "bbb2", "ddd1"
    );

    @Test
    public void testFilter() {
        strings
            .stream() // Convert a collection to a stream via stream() method
            .filter((s) -> s.startsWith("a")) // filter is intermediate
            .forEach(System.out::println); // Foreach is terminal
    }

    @Test
    public void testSorted() {
        strings
            .stream()
            .sorted()
            .filter((s) -> s.startsWith("a"))
            .forEach(System.out::println);
    }

    @Test
    public void testMap() {
        strings
            .stream()
            .map(String::toUpperCase)
            .sorted((a, b) -> b.compareTo(a))
            .forEach(System.out::println);
    }

    @Test
    public void testReduce() {
        double total = IntStream.rangeClosed(10, 20)
            .mapToDouble(i -> Math.sqrt(i))
            .reduce(0, (sum, i) -> sum + i);

        System.out.println(total);
    }

    @Test
    public void testMatch() {
        boolean match = strings
            .stream()
            .anyMatch((s) -> s.startsWith("a"));

        // allMatch
        // noneMatch

        System.out.println(match);
    }

    @Test
    public void testCount() {
        long startsWithB = strings
            .stream()
            .filter((s) -> s.startsWith("b"))
            .count();

        System.out.println(startsWithB);    // 3
    }
}
