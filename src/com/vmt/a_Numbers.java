package com.vmt;

import org.junit.Test;

public class a_Numbers {
    @Test
    public void testNormalArithmetic() {
        Integer i = Integer.MAX_VALUE + 1;
        System.out.println(i);
    }

    @Test(expected=ArithmeticException.class)
    public void testExactArithmetic() {
        Math.addExact(Integer.MAX_VALUE, 1);
    }
}
