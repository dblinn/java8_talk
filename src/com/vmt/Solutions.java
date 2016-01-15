package com.vmt;

import static junit.framework.Assert.assertEquals;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class Solutions {
    // Count unique characters in java 8
    @Test
    public void testUniqueCharactersJava8() {
        long uniqueCharCount = "supercalifragilisticexpialidocious"
            .chars()
            .distinct()
            .count();

        assertEquals(uniqueCharCount, 15);
    }

    // Sort the words in the string "his carried iguana bill"
    // and print the results as a sentence
    @Test
    public void testSplittingAndSortingWords() {
        String sentence = Pattern.compile(" ")
            .splitAsStream("his carried iguana bill")
            .sorted()
            .collect(Collectors.joining(" "));

        System.out.println(sentence);
    }

    @Test
    public void testRangeClosed() {
        // Note that rangeClosed() is INCLUSIVE on the upper end so 20 is included.
        int total = IntStream.rangeClosed(10, 20)
            .map(i -> i * i)
            .reduce(0, (sum, i) -> sum + i);

        System.out.println(total);
        assertEquals(2585, total);
    }

//    @Test
//    public void testJava8CommandPattern() {
//        Light light = new Light(State.OFF);
//        Arrays.<Command>asList(
//            () -> light.setState(State.ON),
//            () -> light.setState(State.OFF),
//            () -> light.setState(light.getState().opposite())
//        ).stream().forEach(Command::execute);
//    }
}
