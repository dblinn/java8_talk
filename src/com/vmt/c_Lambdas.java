package com.vmt;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class c_Lambdas {
    // Let's start with a simple example of how to sort a list of strings in prior versions of Java:
    @Test
    public void testStringSortJava7() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println(names);
    }

    @Test
    public void testStringSortWithLambda() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        System.out.println(names);
    }

    @Test
    public void testStringSortLambdaImplicitReturn() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        // Implement sort

        System.out.println(names);
    }

    @Test
    public void testStringSortLambdaTypeInference() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        names.sort((a, b) -> b.compareTo(a));

        System.out.println(names);
    }
}
