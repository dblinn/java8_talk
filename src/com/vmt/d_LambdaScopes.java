package com.vmt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// Local variables must be implicit final
// Static and member variables from class scope may be reassigned
public class d_LambdaScopes {
    @FunctionalInterface interface Converter<F, T> { T convert(F from); }

    // Accessing outer scope variables from lambda expressions is very
    // similar to anonymous objects. You can access final variables
    // from the local outer scope as well as instance fields and
    // static variables.
    @Test
    public void testLocalVariableAccess() {
        final int num = 1;
        Converter<Integer, String> stringConverter =
            (from) -> String.valueOf(from + num);

        stringConverter.convert(2);     // 3
    }

    @Test
    // Local variables used in lambda scope must be
    // implicitly (effectively) final
    public void testLocalImplicitFinal() {
//        int num = 1;
//        Converter<Integer, String> stringConverter =
//            (from) -> String.valueOf(from + num);
//        num = 3;
    }

    static int outerStaticNum;
    int outerNum;

    Converter<Integer, String> stringConverterStatic = (from) -> {
        outerStaticNum = 15;
        return String.valueOf(from);
    };

    Converter<Integer, String> stringConverterMember = (from) -> {
        outerNum = 33;
        return String.valueOf(from);
    };

    @Test
    public void testLambdaStaticVariableAccess() {
        d_LambdaScopes scopes = new d_LambdaScopes();
        assertEquals("4", scopes.stringConverterStatic.convert(4));
        assertEquals(15, d_LambdaScopes.outerStaticNum);
    }

    @Test
    public void testLambdaMemberVariableAccess() {
        d_LambdaScopes scopes = new d_LambdaScopes();
        assertEquals("4", scopes.stringConverterMember.convert(4));
        assertEquals(33, scopes.outerNum);
    }
}
