package com.vmt;

import org.junit.Test;

public class i_DefaultInterfaceMethods {
    interface Formula {
        double calculate(int a);

        default double sqrt(int a) {
            return Math.sqrt(a);
        }
    }

    @Test
    public void testInterfaceDefaultMethod() {
        // Note that you can actually declare a functional interface with default methods
        // and turn this into a lambda!
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));     // 100.0
        System.out.println(formula.sqrt(16));           // 4.0
    }
}
