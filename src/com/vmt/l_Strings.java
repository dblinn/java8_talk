package com.vmt;

import static junit.framework.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class l_Strings {
    // Count unique chars in Java 7 using a HashSet
    @Test
    public void testUniqueCharactersJava7() {
        HashSet<Character> hash = new HashSet<>();
        String buf = "supercalifragilisticexpialidocious";
        for (int i = 0; i < buf.length(); i++) {
            hash.add(buf.charAt(i));
        }

        assertEquals(hash.size(), 15);
    }

    // Count unique characters in java 8
    @Test
    public void testUniqueCharactersJava8() {
    }

    // Sort the words in the string "his carried iguana bill"
    // and print the results as a sentence
    @Test
    public void testSplittingAndSortingWords() {
        String input = "his carried iguana bill";
        String[] words = input.split(" ");
        Arrays.sort(words);

        StringBuilder results = new StringBuilder();
        for (String s : words) {
            results.append(s).append(" ");
        }
        System.out.println(results);
    }
}
