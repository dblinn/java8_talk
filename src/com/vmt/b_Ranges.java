package com.vmt;

import static junit.framework.Assert.assertEquals;

import java.util.stream.IntStream;

import org.junit.Test;

public class b_Ranges {
    // Calculate the sum of squares of numbers between 10 and 19
    @Test
    public void testRange() {
        // Note that range() is EXCLUSIVE on the upper end so 20 is not included.
        int total = IntStream.range(10, 20)
            .map(i -> i * i)
            .reduce(0, (sum, i) -> sum + i);

        System.out.println(total);
        assertEquals(2185, total);
    }

    @Test
    public void testRangeClosed() {
    }
}
